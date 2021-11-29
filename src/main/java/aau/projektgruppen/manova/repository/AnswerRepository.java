package aau.projektgruppen.manova.repository;

import aau.projektgruppen.manova.model.Answer;
//import com.example.demo.model.QAMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository <Answer, Long> {
}
