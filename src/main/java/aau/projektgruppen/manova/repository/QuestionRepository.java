package aau.projektgruppen.manova.repository;

import aau.projektgruppen.manova.model.Question;
import aau.projektgruppen.manova.model.projection.QARecruiterDTO;
import aau.projektgruppen.manova.model.projection.QAStudentDTO;
import aau.projektgruppen.manova.model.projection.QAModeratorDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * this class holds all the queries regarding getting access to {@link aau.projektgruppen.manova.model.Question questions}
 * with specific attributes. the class is an interface extended from {@link JpaRepository}.
 *
 * @author Tommy Grenaae
 */
public interface QuestionRepository extends JpaRepository <Question, Long> {
    /**
     * query to get all the questions that are approved by the {@link aau.projektgruppen.manova.model.user.Moderator Moderator}.
     * @param session_id , a {@code long} indicating from which {@link aau.projektgruppen.manova.model.Session Session}
     *                   there should be returned questions from.
     * @return a list of {@link aau.projektgruppen.manova.model.projection.QAStudentDTO QAStudentDTO}.
     */
    @Query("SELECT new aau.projektgruppen.manova.model.projection.QAStudentDTO(q.id, q.question, q.timeOfCreation, a.answer, a.timeOfCreation) " +
            "FROM Question q LEFT OUTER JOIN q.answer a " +
            "WHERE q.approved = true AND q.session.id = :session_id")
    List<QAStudentDTO> findApproved(long session_id);

    /**
     * query to get all the questions that are sent to the {@link aau.projektgruppen.manova.model.user.Recruiter Recruiter}
     * for review by the {@link aau.projektgruppen.manova.model.user.Moderator Moderator}.
     * @param session_id , a {@code long} indicating from which {@link aau.projektgruppen.manova.model.Session Session}
     *                   there should be returned questions from.
     * @return a list of {@link aau.projektgruppen.manova.model.projection.QARecruiterDTO QARecruiterDTO}.
     */
    @Query("SELECT new aau.projektgruppen.manova.model.projection.QARecruiterDTO(q.id, q.question) " +
            "FROM Question q " +
            "WHERE q.markedForReview = true AND q.session.id = :session_id")
    List<QARecruiterDTO> findReviewed(long session_id);

    /**
     * query to get all the questions from a given {@code Session} that are not yet approved by the
     * {@link aau.projektgruppen.manova.model.user.Moderator Moderator}.
     * @param session_id , a {@code long} indicating from which {@link aau.projektgruppen.manova.model.Session Session}
     *                   there should be returned questions from.
     * @return a list of {@link aau.projektgruppen.manova.model.projection.QAModeratorDTO QAModeratorDTO}.
     */
    @Query("SELECT new aau.projektgruppen.manova.model.projection.QAModeratorDTO(q.id, q.question, q.markedForReview) " +
            "FROM Question q " +
            "WHERE q.approved = false AND q.session.id = :session_id")
    List<QAModeratorDTO> findUnApproved(long session_id);

    /**
     * query to get all the questions that are not yet approved by the {@link aau.projektgruppen.manova.model.user.Moderator Moderator}.
     * @return a list of {@link aau.projektgruppen.manova.model.projection.QAModeratorDTO QAModeratorDTO}.
     */
    @Query("SELECT new aau.projektgruppen.manova.model.projection.QAModeratorDTO(q.id, q.question, q.markedForReview) " +
            "FROM Question q " +
            "WHERE q.approved = false")
    List<QAModeratorDTO> findAllUnApproved();


    @Query("SELECT q FROM Question q WHERE q.session.id = :session_id")
    List<Question> findAllBySessionId(long session_id);
}
