package com.example.realtimerendering.service.impl;

import com.example.realtimerendering.model.request.RequestStock;
import com.github.pagehelper.PageInfo;
import com.example.realtimerendering.common.commonEnum.CommonEnum;
import com.example.realtimerendering.dao.StockMapper;
import com.example.realtimerendering.model.dto.Stock;
import com.example.realtimerendering.service.StockService;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockMapper stockMapper;

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public List<Stock> getAllStock(RequestStock requestStock) {
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("deleteFlag", CommonEnum.DELETE_FLAG_NOT_DELETE);

        List<Stock> allStock = stockMapper.getAllStock(paramMap);

        return allStock;
    }

    @Override
    public PageInfo<Stock> getStockByPage(RequestStock requestStock) {
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("deleteFlag", CommonEnum.DELETE_FLAG_NOT_DELETE);
        paramMap.put("condition", requestStock.getCondition());

        //redisTemplate
        ValueOperations<String, String> string = redisTemplate.opsForValue();

        String key = "user_id::"+requestStock.getCondition();
        String ids = string.get(key);

        //redis 값 체크
        if (requestStock.getPageNum() == 1 || StringUtil.isNullOrEmpty(ids)){
            //100 data
//            PageHelper.startPage(1,100);
            List<Stock> rankingList = stockMapper.getAllStock(paramMap);
//            PageHelper.clearPage();

            //redis save
            StringBuffer value = new StringBuffer();
            List<Integer> collect = rankingList.stream().map(Stock::getId).collect(Collectors.toList());
            for (Integer integer : collect) {
                value.append(integer);
                value.append(",");
            }
            string.set(key,value.toString());
        }

        //redis 저장 값 받기
        ids = string.get(key);
        String[] split = ids.split(",");
        Integer pageNum = requestStock.getPageNum();
        Integer pageSize = requestStock.getPageSize();
        List<Integer> queryIds = new ArrayList<>();

        //oversize check
        int maxLength = pageNum*pageSize ;
        if ((pageNum-1)*pageSize >= maxLength){
            return new PageInfo<>();
        }
        if (maxLength > split.length){
            maxLength = split.length;
        }
        for (int i = (pageNum-1)*pageSize; i < maxLength; i++) {
            queryIds.add(Integer.parseInt(split[i]));
        }

        //list 검색
        List<Stock> stockByIdWithPage = stockMapper.getStockByIds(queryIds);

        List<Stock> result = new ArrayList<>();
        //countList
        Map<Integer, Stock> collect = stockByIdWithPage.stream().collect(Collectors.toMap(Stock::getId, stock -> stock));
        for (Integer queryId : queryIds) {
            result.add(collect.get(queryId));
        }

        return new PageInfo<>(result);
    }

    @Override
    public List<Stock> getMostFiveStock(String searchOrderCondition) {
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("condition", searchOrderCondition);
        paramMap.put("limit", 5);
        paramMap.put("deleteFlag", CommonEnum.DELETE_FLAG_NOT_DELETE);

        return stockMapper.getMostFiveStock(paramMap);
    }

    @Override
    public List<Stock> getStockByIds(List<Integer> stockIds) {
        return stockMapper.getStockByIds(stockIds);
    }
}
