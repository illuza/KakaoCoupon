package kr.misa.kakao_coupon.util;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import kr.misa.kakao_coupon.model.Coupon;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReadCsv {
    private String filename = "a.csv";

    public List<Coupon> perform() {
        List<Coupon> readCoupons = null;
        Path myPath = Paths.get(filename);

        try (BufferedReader br = Files.newBufferedReader(myPath, StandardCharsets.UTF_8)) {
            ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
            strategy.setType(Coupon.class);
            String[] fields = {"ID", "Expired date", "User", "Used"};
            strategy.setColumnMapping(fields);

            CsvToBean csvToBean = new CsvToBeanBuilder(br)
                    .withType(Coupon.class)
                    .withMappingStrategy(strategy)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            readCoupons = csvToBean.parse();

            return readCoupons;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readCoupons;
    }
}
