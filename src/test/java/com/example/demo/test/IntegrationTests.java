package com.example.demo.test;

import com.example.demo.model.Answer;
import com.example.demo.model.Organisation;
import com.example.demo.model.Question;
import com.example.demo.model.Session;
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
    private Question        q1, q2, q3, q4;
    private Answer          a1, a2, a3, a4;

    /** sets up all the stuff that was previously in Application.java */
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

        // Setup Answers
        a1 = aRepo.save(new Answer("bar1!", qRepo.getOne(1L)));
        a2 = aRepo.save(new Answer("bar2!", qRepo.getOne(2L)));
        a3 = aRepo.save(new Answer("bar3!", qRepo.getOne(3L)));
        a4 = aRepo.save(new Answer("bar4!", qRepo.getOne(4L)));
    }

    @Test
    public void find_approved_question() {
        String expected = q1.getQuestion();
        List<QAStudentDTO> result = qRepo.findApproved(1);
        assertFalse(result.isEmpty());
        assertEquals(expected, result.get(0).getQuestion());
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
