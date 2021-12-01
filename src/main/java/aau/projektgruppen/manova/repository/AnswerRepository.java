package aau.projektgruppen.manova.repository;

import aau.projektgruppen.manova.model.Answer;
//import com.example.demo.model.QAMessage;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * this class handles all queries regarding {@link aau.projektgruppen.manova.model.Answer answers}. the class is an
 * interface extended from {@link JpaRepository}.
 *
 * @author Tommy Grenaae
 */
public interface AnswerRepository extends JpaRepository <Answer, Long> {
}
