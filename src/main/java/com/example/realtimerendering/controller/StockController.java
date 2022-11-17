package com.example.realtimerendering.controller;


import com.example.realtimerendering.common.commonEnum.CommonEnum;
import com.example.realtimerendering.common.dto.SwaggerDto;
import com.example.realtimerendering.model.dto.Stock;
import com.example.realtimerendering.model.request.RequestStock;
import com.example.realtimerendering.service.StockService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/homepage")
public class StockController {

    @Autowired
    private StockService stockService;

    @ApiOperation(value = "종목 list 검색",httpMethod = "GET")
    @ApiImplicitParam(name = "requestStock" , value = "종목 검색 조건" , required = false )
    @RequestMapping(value =  "/getAllStock" , method = RequestMethod.GET)
    public SwaggerDto<Stock> getAllStock(RequestStock requestStock){
        SwaggerDto<Stock> swaggerMap = new SwaggerDto<>();
        swaggerMap.setResultCode(CommonEnum.RESULT_FAIL);

        try {
            List<Stock> stockList = stockService.getAllStock(requestStock);

            swaggerMap.setResultCode(CommonEnum.RESULT_SUCCESS);
            swaggerMap.setResultList(stockList);
            swaggerMap.setResultMsg("검색 성공");
        } catch (Exception e) {
            e.printStackTrace();
            swaggerMap.setErrorMsg("검색 실패");
        }

        return swaggerMap;

    }

    @ApiOperation(value = "종목 검색 page",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "condition" , value = "condition" , required = true),
            @ApiImplicitParam(name = "pageNum" , value = "pageNum" , required = true),
            @ApiImplicitParam(name = "pageSize" , value = "pageSize" , required = true)
    })
    @RequestMapping(value =  "/getStockByPage" , method = RequestMethod.GET)
    public SwaggerDto<Stock> getStockByPage(RequestStock requestStock){
        SwaggerDto<Stock> swaggerMap = new SwaggerDto<>();
        swaggerMap.setResultCode(CommonEnum.RESULT_FAIL);

        try {
            PageInfo<Stock> stockByPage = stockService.getStockByPage(requestStock);

            swaggerMap.setResultCode(CommonEnum.RESULT_SUCCESS);
            swaggerMap.setResultPage(stockByPage);
            swaggerMap.setResultMsg("검색 성공");
        } catch (Exception e) {
            e.printStackTrace();
            swaggerMap.setErrorMsg("검색 실패");
        }

        return swaggerMap;

    }

    @ApiOperation(value = "id 통해서 종목 검색",httpMethod = "GET")
    @RequestMapping(value =  "/getStockByIds" , method = RequestMethod.GET)
    public SwaggerDto<Stock> getStockByIds(@RequestParam(value = "id") List<Integer> stockIds){
        SwaggerDto<Stock> swaggerMap = new SwaggerDto<>();
        swaggerMap.setResultCode(CommonEnum.RESULT_FAIL);

        if (stockIds == null || stockIds.size() <= 0 ){
            swaggerMap.setErrorMsg("id is null");
            return swaggerMap;
        }

        try {
            List<Stock> stockList = stockService.getStockByIds(stockIds);

            swaggerMap.setResultCode(CommonEnum.RESULT_SUCCESS);
            swaggerMap.setResultList(stockList);
            swaggerMap.setResultMsg("검색 성공");
        } catch (Exception e) {
            e.printStackTrace();
            swaggerMap.setErrorMsg("검색 실패");
        }

        return swaggerMap;

    }

    @ApiOperation(value = "top 5 종목 정보 검색",httpMethod = "GET")
    @ApiImplicitParam(name = "searchOrderCondition" , value = "검색 순서 조건" , required = true )
    @RequestMapping(value =  "/getMostFiveStock" , method = RequestMethod.GET)
    public SwaggerDto<Stock> getMostFiveStock(String searchOrderCondition){
        SwaggerDto<Stock> swaggerMap = new SwaggerDto<>();
        swaggerMap.setResultCode(CommonEnum.RESULT_FAIL);

        try {
            List<Stock> StockList = stockService.getMostFiveStock(searchOrderCondition);

            swaggerMap.setResultCode(CommonEnum.RESULT_SUCCESS);
            swaggerMap.setResultList(StockList);
            swaggerMap.setResultMsg("검색 성공");
        } catch (Exception e) {
            e.printStackTrace();
            swaggerMap.setErrorMsg("검색 실패");
        }

        return swaggerMap;

    }
}
