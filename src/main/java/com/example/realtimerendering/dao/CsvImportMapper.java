package com.example.realtimerendering.dao;

import com.example.realtimerendering.model.dto.Stock;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CsvImportMapper {

    void batchInsertStock(@Param("stockList") List<Stock> stockList);
}

