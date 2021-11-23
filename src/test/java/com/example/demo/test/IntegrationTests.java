package com.example.demo.test;

import com.example.demo.model.Organisation;
import com.example.demo.repository.OrganisationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {Organisation.class, OrganisationRepository.class})
public class IntegrationTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private OrganisationRepository orgRepo;

    @Test
    public void whenFindByNameThenReturnOrg() {
        Organisation expected = new Organisation("Politi");
        entityManager.persist(expected);
        entityManager.flush();

        Organisation result = orgRepo.findByName(expected.getName());

        assertThat(result.getName())
                .isEqualTo(expected.getName());
    }
}
