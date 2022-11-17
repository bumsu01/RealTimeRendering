package com.example.realtimerendering.service.impl;

import com.example.realtimerendering.dao.AutoUpdateMapper;
import com.example.realtimerendering.model.dto.Stock;
import com.example.realtimerendering.service.AutoUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoUpdateServiceImpl implements AutoUpdateService {

    @Autowired
    private AutoUpdateMapper autoUpdateMapper;

    @Override
    public void updateNowPriceRandom(List<Stock> updateStockList) {

        for (Stock stock : updateStockList) {
            autoUpdateMapper.updateNowPriceRandom(stock);
        }
    }
}
