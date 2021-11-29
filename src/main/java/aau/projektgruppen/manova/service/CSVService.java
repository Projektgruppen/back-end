package aau.projektgruppen.manova.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import aau.projektgruppen.manova.model.Answer;
import aau.projektgruppen.manova.model.Question;
import aau.projektgruppen.manova.repository.AnswerRepository;
import aau.projektgruppen.manova.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aau.projektgruppen.manova.helper.CSVHelper;


@Service
public class CSVService {

    @Autowired
    QuestionRepository qRepository;
    AnswerRepository aRepository;

    public ByteArrayInputStream load() {
        List<Question> questions = qRepository.findAll();
        List<Answer> answers = aRepository.findAll();

        ByteArrayInputStream in = CSVHelper.qaMessageToCSV(questions, answers);
        return in;
    }
}
