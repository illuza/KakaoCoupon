package kr.misa.kakao_coupon.util;

import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvException;
import kr.misa.kakao_coupon.model.Coupon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.util.List;

public class WriteCsvToResponse {
    private static final Logger LOGGER = LoggerFactory.getLogger(WriteCsvToResponse.class);

    public static void writeCoupons(PrintWriter writer, List<Coupon> coupons) {

        try {

            ColumnPositionMappingStrategy<Coupon> mapStrategy
                    = new ColumnPositionMappingStrategy<>();

            mapStrategy.setType(Coupon.class);

            String[] columns = new String[]{"ID", "Expired date", "User", "Used"};
            mapStrategy.setColumnMapping(columns);

            StatefulBeanToCsv<Coupon> btcsv = new StatefulBeanToCsvBuilder<Coupon>(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .withMappingStrategy(mapStrategy)
                    .withSeparator(',')
                    .build();

            btcsv.write(coupons);

        } catch (CsvException ex) {
            LOGGER.error("Error mapping Bean to CSV", ex);
        }
    }
}
