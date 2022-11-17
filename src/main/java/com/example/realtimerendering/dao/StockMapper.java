package com.example.realtimerendering.dao;

import com.example.realtimerendering.model.dto.Stock;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface StockMapper {
    List<Stock> getAllStock(@Param("paramMap") Map<String, Object> paramMap);

    List<Stock> getMostFiveStock(@Param("paramMap") Map<String, Object> paramMap);

    List<Stock> getStockByIds(@Param("stockIds")List<Integer> stockIds);
}
