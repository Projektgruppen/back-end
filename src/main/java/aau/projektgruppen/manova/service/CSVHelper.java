package aau.projektgruppen.manova.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    public static ByteArrayInputStream questionToCSV(List<Question> questions) {


        final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format)) {

            List<String> data = new ArrayList<>();
            data.add("Number of messages, Question Id,Question,Session Id, Answer ");
            csvPrinter.printRecord(data);
            for (Question question : questions) {
                if(question.getAnswer() == null){
                    Answer answer = new Answer();
                    answer.setAnswer("no answer");
                    question.setAnswer(answer);
                }

                 data = Arrays.asList(
                        String.valueOf(question.getId()),
                        question.getQuestion(),
                        String.valueOf(question.getSession().getId()),
                        question.getAnswer().getAnswer()

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