package com.example.realtimerendering.service.impl;

import com.example.realtimerendering.dao.CsvImportMapper;
import com.example.realtimerendering.model.dto.Stock;
import com.example.realtimerendering.service.CsvImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CsvImportServiceImpl implements CsvImportService {

    @Autowired
    private CsvImportMapper csvImportMapper;

    @Override
    public void batchInsertStock(List<Stock> stockList) {
        csvImportMapper.batchInsertStock(stockList);
    }
}
