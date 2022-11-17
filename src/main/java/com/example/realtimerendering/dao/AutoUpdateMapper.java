package com.example.realtimerendering.dao;

import com.example.realtimerendering.model.dto.Stock;
import com.example.realtimerendering.model.dto.Stock;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AutoUpdateMapper {

    void updateNowPriceRandom(@Param("stock") Stock saveStockList);
}
