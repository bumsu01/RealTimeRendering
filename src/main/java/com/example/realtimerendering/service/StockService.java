package com.example.realtimerendering.service;

import com.github.pagehelper.PageInfo;
import com.example.realtimerendering.model.dto.Stock;
import com.example.realtimerendering.model.request.RequestStock;

import java.util.List;

public interface StockService {
    /**
     * 전체 종목 정보 검색
     * @param requestStock
     * @return
     */
    List<Stock> getAllStock(RequestStock requestStock);

    /**
     * 페이지로 종목 정보 검색
     * @param requestStock
     * @return
     */
    PageInfo<Stock> getStockByPage(RequestStock requestStock);

    /**
     * 조건을 기준으로 top 5 검색
     * @param searchOrderByCondition
     * @return
     */
    List<Stock> getMostFiveStock(String searchOrderByCondition);

    /**
     * 종목 id 로 종목 정보 검색
     * @param stockIds
     * @return
     */
    List<Stock> getStockByIds(List<Integer> stockIds);
}
