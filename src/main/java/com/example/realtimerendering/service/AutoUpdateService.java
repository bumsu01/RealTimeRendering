package com.example.realtimerendering.service;

import com.example.realtimerendering.model.dto.Stock;

import java.util.List;

public interface AutoUpdateService {
    void updateNowPriceRandom(List<Stock> autoUpdateStockList);
}