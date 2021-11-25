package com.example.demo.test;

import com.example.demo.model.Answer;
import com.example.demo.model.Organisation;
import com.example.demo.model.Question;
import com.example.demo.model.Session;
import com.example.demo.model.projection.QAModeratorDTO;
import com.example.demo.model.projection.QAStudentDTO;
import com.example.demo.repository.AnswerRepository;
import com.example.demo.repository.OrganisationRepository;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.repository.SessionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class IntegrationTests {

    @Autowired private TestEntityManager entityManager;

    @Autowired private OrganisationRepository oRepo;
    @Autowired private SessionRepository sRepo;
    @Autowired private QuestionRepository qRepo;
    @Autowired private AnswerRepository aRepo;

    private Organisation    o1, o2;
    private Session         s1, s2;
    private Question        q1, q2, q3, q4, q5;
    private Answer          a1, a2, a3, a4, a5;

    /** sets up all the stuff that was previously in Application.java */
    // TODO: This doesn't work as intended -> Run tests one by one.
    @BeforeEach
    public void eachSetup() {
        // Setup Organisations
        o1 = oRepo.save(new Organisation("Forsvaret"));
        o2 = oRepo.save(new Organisation("Politiet"));

        // Setup Sessions
        s1 = sRepo.save(new Session(o1));
        s2 = sRepo.save(new Session(o2));

        // Setup Questions
        q1 = qRepo.save(new Question("Foo1?", true, true, s1));
        q2 = qRepo.save(new Question("Foo2?", true, true, s2));
        q3 = qRepo.save(new Question("Foo3?", false, false, s2));
        q4 = qRepo.save(new Question("Foo4?", false, false, s2));
        q5 = qRepo.save(new Question("Det virker ikke?", false, false, s1));

        // Setup Answers
        a1 = aRepo.save(new Answer("bar1!", qRepo.getOne(1L)));
        a2 = aRepo.save(new Answer("bar2!", qRepo.getOne(2L)));
        a3 = aRepo.save(new Answer("bar3!", qRepo.getOne(3L)));
        a4 = aRepo.save(new Answer("bar4!", qRepo.getOne(4L)));
        a5 = aRepo.save(new Answer("fejl 40!", qRepo.getOne(5L)));
    }

    @Test
    public void find_approved_question() {
        String expected = q1.getQuestion();
        List<QAStudentDTO> result = qRepo.findApproved(1);
        assertFalse(result.isEmpty());
        assertEquals(expected, result.get(0).getQuestion());
    }

    @Test
    public void find_reviewed_question() {
        String expected = q2.getQuestion();
        List<QAModeratorDTO> result = qRepo.findReviewed(2);
        assertFalse(result.isEmpty());
        assertEquals(expected, result.get(0).getQuestion());
    }

    @Test
    public void find_unapproved_question() {
        String expectedA = q3.getQuestion();
        String expectedB = q4.getQuestion();
        List<QAModeratorDTO> result = qRepo.findUnApproved(2);
        assertFalse(result.isEmpty());
        assertEquals(expectedA, result.get(0).getQuestion());
        assertEquals(expectedB, result.get(1).getQuestion());
    }

    @Test
    public void find_all_unapproved_questions() {
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
    public void createQuestion() {
        String myQuestion = "Foo";
        Question q = new Question();
        q.setQuestion(myQuestion);
        Question created = qRepo.save(q);

        assertNotNull(created);
        assertEquals(myQuestion, created.getQuestion());
    }

    @Test
    public void whenFindByNameThenReturnOrg() {
        Organisation expected = new Organisation("Politi");
        entityManager.persist(expected);
        entityManager.flush();

        Organisation result = oRepo.findByName(expected.getName());

        assertThat(expected.getName())
                .isEqualTo(result.getName());
    }
}
