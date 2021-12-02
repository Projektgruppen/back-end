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

    public ByteArrayInputStream load(Long sessionId) {
        List<Question> questions = qRepository.findAllBySessionId(sessionId);

        ByteArrayInputStream in = CSVHelper.questionToCSV(questions);
        return in;
    }
}
