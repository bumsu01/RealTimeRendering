package com.example.realtimerendering.common.task;

import com.example.realtimerendering.service.AutoUpdateService;
import com.example.realtimerendering.model.dto.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableScheduling
public class AutoUpdateTask {

    @Autowired
    private AutoUpdateService autoUpdateService;

    // 3초에 한 번씩
    @Scheduled(cron = "0/3 * * * * ?")
    private void configureTasks() {
        List<Stock> updateStockList = new ArrayList<>();

        Integer priceMin = 1000;
        Integer priceMax = 100000;
        Integer viewMin = 10;
        Integer viewMax = 50;
        Integer tradeMin = 10;
        Integer tradMax = 100;

        for (int i = 0; i < 120; i++) {
            Stock stock = new Stock();
            stock.setId(i+1);
            stock.setViewCount((int)(Math.random() * (viewMax - viewMin)) + viewMin);
            stock.setNowPrice((int)(Math.random() * (priceMax - priceMin)) + priceMin);
            stock.setTradeCount((int)(Math.random() * (tradMax - tradeMin)) + tradeMin);
            updateStockList.add(stock);
        }

        autoUpdateService.updateNowPriceRandom(updateStockList);
    }
}
