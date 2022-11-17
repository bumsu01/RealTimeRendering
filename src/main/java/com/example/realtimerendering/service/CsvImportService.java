package com.example.realtimerendering.service;

import com.example.realtimerendering.model.dto.Stock;

import java.util.List;

public interface CsvImportService {
    void batchInsertStock(List<Stock> stockList);
}