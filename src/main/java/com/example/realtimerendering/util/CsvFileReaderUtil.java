package com.example.realtimerendering.util;

import com.example.realtimerendering.common.commonEnum.CommonEnum;
import com.example.realtimerendering.model.dto.Stock;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CsvFileReaderUtil {

    public List<Stock> readCSV() {
        List<Stock> stockList = new ArrayList<>();
        File csv = new File(CsvFileReaderUtil.class.getResource("/static/SampleData_CSV.csv").getFile());
        BufferedReader br = null;
        String line = "";

        try {
            Date createTime = new Date();
            br = new BufferedReader(new FileReader(csv));
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] lineArr = line.split(",");

                Stock stock = new Stock();
                stock.setId(Integer.parseInt(lineArr[0]));
                stock.setCode(lineArr[1]);
                stock.setName(lineArr[2]);
                stock.setStartPrice(Integer.parseInt(lineArr[3]));
                stock.setCreateTime(createTime);
                stock.setDeleteFlag(CommonEnum.DELETE_FLAG_NOT_DELETE);
                stockList.add(stock);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stockList;
    }
}
