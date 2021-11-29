package aau.projektgruppen.manova.helper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import aau.projektgruppen.manova.model.Answer;
import aau.projektgruppen.manova.model.Question;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.QuoteMode;

/**
 * Library class that converts entities from a database to a .csv file.
 * CSV files will contain every {@link Question} and {@link Answer} from a given session.
 *
 */

public class CSVHelper {

    public static ByteArrayInputStream qaMessageToCSV(List<Question> questions, List<Answer> answers) {

        //Answer answer = new Answer();

        final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
            for (Question question : questions) {
                List<String> data = Arrays.asList(
                        String.valueOf(question.getId()),
                        question.getQuestion(),
                        String.valueOf(question.getApprove())
                        //answer.getAnswer()
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