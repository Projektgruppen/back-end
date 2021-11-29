package aau.projektgruppen.manova.repository;

import aau.projektgruppen.manova.model.Question;
import aau.projektgruppen.manova.model.projection.QAStudentDTO;
import aau.projektgruppen.manova.model.projection.QAModeratorDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface QuestionRepository extends JpaRepository <Question, Long> {
    @Query("SELECT new aau.projektgruppen.manova.model.projection.QAStudentDTO(q.question, q.answer.answer) " +
            "FROM Question q LEFT OUTER JOIN q.answer a " +
            "WHERE q.approved = true AND q.session.id = :session_id")
    List<QAStudentDTO> findApproved(long session_id);

    @Query("SELECT new aau.projektgruppen.manova.model.projection.QAModeratorDTO(q.question, q.id) " +
            "FROM Question q " +
            "WHERE q.markedForReview = true AND q.session.id = :session_id")
    List<QAModeratorDTO> findReviewed(long session_id);

    @Query("SELECT new aau.projektgruppen.manova.model.projection.QAModeratorDTO(q.question, q.id) " +
            "FROM Question q " +
            "WHERE q.approved = false AND q.session.id = :session_id")
    List<QAModeratorDTO> findUnApproved(long session_id);

    @Query("SELECT new aau.projektgruppen.manova.model.projection.QAModeratorDTO(q.question, q.id) " +
            "FROM Question q " +
            "WHERE q.approved = false")
    List<QAModeratorDTO> findAllUnApproved();
}
