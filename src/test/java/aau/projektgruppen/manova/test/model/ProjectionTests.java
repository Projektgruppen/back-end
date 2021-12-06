package aau.projektgruppen.manova.test.model;

import aau.projektgruppen.manova.model.projection.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link aau.projektgruppen.manova.model.projection} package.
 * Contains tests for all the DTO classes
 *
 * @author Mathias Gigas
 */
public class ProjectionTests {

    GenericDTO generic;
    QAModeratorDTO moderator;
    QASessionDTO session;
    QAStudentDTO student;

    @BeforeEach
    void setup() {
        generic = new GenericDTO(1, "foo");
        moderator = new QAModeratorDTO(2, "foo2", true);
        session = new QASessionDTO(3, 3, "footime");
        student = new QAStudentDTO(4, "Q", "timeApprove", "A", "timeCreate");

    }

    // --- GenericDTO ----------------------------------------------------------
    @Test
    void getQuestionId_GenericDTO() {
        assertEquals(1, generic.getQuestionId());
    }

    @Test
    void getQuestion_GenericDTO() {
        assertEquals("foo", generic.getQuestion());
    }

    @Test
    void toString_GenericDTO_contains_id_and_question() {
        String s = generic.toString();
        assertTrue(s.contains("1"));    // ID
        assertTrue(s.contains("foo"));  // Question
    }

    // --- QAModeratorDTO ------------------------------------------------------
    @Test
    void isMarkedForReview_QAModeratorDTO() {
        assertTrue(moderator.isMarkedForReview());
    }

    // --- QARecruiterDTO ------------------------------------------------------
    // This does not contain any additional functionality compared to its super.

    // --- QASessionDTO --------------------------------------------------------
    @Test
    void getSessionId_QASessionDTO() {
        assertEquals(3, session.getSessionId());
    }

    @Test
    void getOrganisationId_QASessionDTO() {
        assertEquals(3, session.getOrganisationId());
    }

    @Test
    void getTimeOfCreation_QASessionDTO() {
        assertEquals("footime", session.getTimeOfCreation());
    }

    // --- QAStudentDTO --------------------------------------------------------
    @Test
    void getAnswer_QAStudentDTO() {
        assertEquals("A", student.getAnswer());
    }

    @Test
    void getTimeOfApprovalForQuestion_QAStudentDTO() {
        assertEquals("timeApprove", student.getTimeOfApprovalForQuestion());
    }

    @Test
    void getTimeOfCreationForAnswer_QAStudentDTO() {
        assertEquals("timeCreate", student.getTimeOfCreationForAnswer());
    }

    @Test
    void toString_QAStudentDTO() {
        String ts = student.toString();
        String a = student.getAnswer();
        String toa = student.getTimeOfApprovalForQuestion();
        String toc = student.getTimeOfCreationForAnswer();

        assertTrue(ts.contains(a));
        assertTrue(ts.contains(toa));
        assertTrue(ts.contains(toc));
    }

    // --- QAStudentDTOComparator ----------------------------------------------
    @Test // FIXME: Is this even used anywhere?
    void compare_two_QAStudentDTOs() {
        QAStudentDTO a,b;
        QAStudentDTOComparator c = new QAStudentDTOComparator();
        a = new QAStudentDTO(
                0,
                null,
                "11:15",
                null,
                null
                );
        b = new QAStudentDTO(
                0,
                null,
                "11:30",
                null,
                null
        );

        // a < b
        assertTrue(c.compare(a,b) < 0);
    }
}
