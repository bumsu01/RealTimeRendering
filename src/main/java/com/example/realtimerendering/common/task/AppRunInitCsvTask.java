package com.example.realtimerendering.common.task;

import com.kakao.bumsu01.model.dto.Stock;
import com.kakao.bumsu01.service.CsvImportService;
import com.kakao.bumsu01.uitl.CsvFileReaderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AppRunInitCsvTask  implements ApplicationRunner {

    @Autowired
    private CsvImportService csvImportService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //h2 database data init
        CsvFileReaderUtil csvFileReader = new CsvFileReaderUtil();
        List<Stock> stockList = csvFileReader.readCSV();

        System.out.println(stockList);

        csvImportService.batchInsertStock(stockList);

        System.out.println("=========");

    }

}