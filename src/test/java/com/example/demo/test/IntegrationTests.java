package com.example.demo.test;

import com.example.demo.model.Organisation;
import com.example.demo.model.Question;
import com.example.demo.repository.OrganisationRepository;
import com.example.demo.repository.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class IntegrationTests {

    @Autowired private TestEntityManager entityManager;
    @Autowired private QuestionRepository repo;
    @Autowired private OrganisationRepository orgRepo;

    @Test
    public void createQuestion() {
        String myQuestion = "Foo";
        Question q = new Question();
        q.setQuestion(myQuestion);
        Question created = repo.save(q);

        assertNotNull(created);
        assertEquals(myQuestion, created.getQuestion());
    }

    @Test
    public void whenFindByNameThenReturnOrg() {
        Organisation expected = new Organisation("Politi");
        entityManager.persist(expected);
        entityManager.flush();

        Organisation result = orgRepo.findByName(expected.getName());

        assertThat(expected.getName())
                .isEqualTo(result.getName());
    }
}
