package com.example.realtimerendering.config;

import com.kakao.bumsu01.uitl.CsvFileReaderUtil;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationConfig  implements ApplicationRunner {

    public void run(ApplicationArguments args) {
        CsvFileReaderUtil csvFileReader = new CsvFileReaderUtil();
        csvFileReader.readCSV();
    }

}
