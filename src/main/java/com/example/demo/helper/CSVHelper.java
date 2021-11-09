package com.example.demo.helper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.QuoteMode;

import com.example.demo.model.QAMessage;

public class CSVHelper {

    public static ByteArrayInputStream qaMessageToCSV(List<QAMessage> qaMessages) {
        final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
            for (QAMessage qaMessage : qaMessages) {
                List<String> data = Arrays.asList(
                        String.valueOf(qaMessage.getId()),
                        qaMessage.getAnswer(),
                        qaMessage.getQuestion(),
                        String.valueOf(qaMessage.isApprove())
                );

                csvPrinter.printRecord(data);
            }

            csvPrinter.flush();
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
        }
    }
}