package aau.projektgruppen.manova.repository;

import aau.projektgruppen.manova.model.Answer;
//import com.example.demo.model.QAMessage;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface handles all queries regarding {@link aau.projektgruppen.manova.model.Answer answers}.
 * It is extended from {@link JpaRepository}.
 *
 */
public interface AnswerRepository extends JpaRepository <Answer, Long> {
}
