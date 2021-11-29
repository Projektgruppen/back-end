package aau.projektgruppen.manova.test;

import aau.projektgruppen.manova.model.Answer;
import aau.projektgruppen.manova.model.Organisation;
import aau.projektgruppen.manova.model.Question;
import aau.projektgruppen.manova.model.Session;
import aau.projektgruppen.manova.model.projection.QAModeratorDTO;
import aau.projektgruppen.manova.model.projection.QAStudentDTO;
import aau.projektgruppen.manova.repository.AnswerRepository;
import aau.projektgruppen.manova.repository.OrganisationRepository;
import aau.projektgruppen.manova.repository.QuestionRepository;
import aau.projektgruppen.manova.repository.SessionRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class IntegrationTests {

    @Autowired private TestEntityManager entityManager;

    @Autowired private OrganisationRepository oRepo;
    @Autowired private SessionRepository sRepo;
    @Autowired private QuestionRepository qRepo;
    @Autowired private AnswerRepository aRepo;

    private Organisation o1, o2;
    private Session s1, s2;
    private Question q1, q2, q3, q4, q5;
    private Answer a1, a2, a3, a4, a5;

    /** sets up all the stuff that was previously in Application.java */
    @BeforeEach
    void eachSetup() {
        // Setup Organisations
        o1 = oRepo.save(new Organisation("Forsvaret"));
        o2 = oRepo.save(new Organisation("Politiet"));

        // Setup Sessions
        s1 = sRepo.save(new Session(o1));
        s2 = sRepo.save(new Session(o2));

        // Setup Questions
        q1 = new Question("Foo1?", s1);
        q1.setApproved(true);
        q1.setMarkedForReview(true);

        q2 = new Question("Foo2?", s2);
        q2.setApproved(true);
        q2.setMarkedForReview(true);

        q1 = qRepo.save(q1);
        q2 = qRepo.save(q2);
        q3 = qRepo.save(new Question("Foo3?", s2));
        q4 = qRepo.save(new Question("Foo4?", s2));
        q5 = qRepo.save(new Question("Det virker ikke?", s1));

        // Setup Answers
        a1 = aRepo.save(new Answer("bar1!"));
        a2 = aRepo.save(new Answer("bar2!"));
        a3 = aRepo.save(new Answer("bar3!"));
        a4 = aRepo.save(new Answer("bar4!"));
        a5 = aRepo.save(new Answer("fejl 40!"));

        q1 = qRepo.findById(1L).get();
        q1.setAnswer(a1);
        q1 = qRepo.save(q1);

        q2 = qRepo.findById(2L).get();
        q2.setAnswer(a2);
        q2 = qRepo.save(q2);

        q3 = qRepo.findById(3L).get();
        q3.setAnswer(a3);
        q3 = qRepo.save(q3);

        q4 = qRepo.findById(4L).get();
        q4.setAnswer(a4);
        q4 = qRepo.save(q4);

        q5 = qRepo.findById(1L).get();
        q5.setAnswer(a1);
        q5 = qRepo.save(q1);
    }

    @AfterEach
    void tearDown () {
    }

    @Test
    void find_approved_question() {
        String expected = q1.getQuestion();
        List<QAStudentDTO> result = qRepo.findApproved(1);
        assertFalse(result.isEmpty());
        assertEquals(expected, result.get(0).getQuestion());
    }

    @Test
    void find_reviewed_question() {
        String expected = q2.getQuestion();
        List<QAModeratorDTO> result = qRepo.findReviewed(2);
        assertFalse(result.isEmpty());
        assertEquals(expected, result.get(0).getQuestion());
    }

    @Test
    void find_unapproved_question() {
        String expectedA = q3.getQuestion();
        String expectedB = q4.getQuestion();
        List<QAModeratorDTO> result = qRepo.findUnApproved(2);
        assertFalse(result.isEmpty());
        assertEquals(expectedA, result.get(0).getQuestion());
        assertEquals(expectedB, result.get(1).getQuestion());
    }

    @Test
    void find_all_unapproved_questions() {
        List<QAModeratorDTO> expectedList = new ArrayList<>();
        expectedList.add(new QAModeratorDTO(q3.getQuestion(), q3.getId()));
        expectedList.add(new QAModeratorDTO(q4.getQuestion(), q4.getId()));
        expectedList.add(new QAModeratorDTO(q5.getQuestion(), q5.getId()));

        List<QAModeratorDTO> result = qRepo.findAllUnApproved();
        // This doesn't work probably because DTO doesn't override hashcode.
        //assertTrue(result.containsAll(expectedList));

        // Doing this instead.
        assertEquals(expectedList.get(0).getQuestionId(), result.get(0).getQuestionId());
        assertEquals(expectedList.get(1).getQuestionId(), result.get(1).getQuestionId());
        assertEquals(expectedList.get(2).getQuestionId(), result.get(2).getQuestionId());
    }

    @Test
    void createQuestion() {
        String myQuestion = "Foo";
        Question q = new Question();
        q.setQuestion(myQuestion);
        Question created = qRepo.save(q);

        assertNotNull(created);
        assertEquals(myQuestion, created.getQuestion());
    }

    @Test
    void whenFindByNameThenReturnOrg() {
        Organisation expected = new Organisation("Politi");
        entityManager.persist(expected);
        entityManager.flush();

        Organisation result = oRepo.findByName(expected.getName());

        assertThat(expected.getName())
                .isEqualTo(result.getName());
    }
}
