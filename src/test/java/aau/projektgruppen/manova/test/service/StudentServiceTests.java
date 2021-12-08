package aau.projektgruppen.manova.test.service;

import aau.projektgruppen.manova.exception.NotFoundException;
import aau.projektgruppen.manova.model.Question;
import aau.projektgruppen.manova.model.Session;
import aau.projektgruppen.manova.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentServiceTests {

    @Autowired
    private StudentService ss;

    @Test
    void getApprovedQuestions_given_nonexistent_org_throws_NotFoundException() {
        String expectedExString = "Organisation with name: Nonexistent Org not found";
        NotFoundException expected = assertThrows(NotFoundException.class,
                () -> ss.findAllApprovedQuestions("Nonexistent Org"),
                "Incorrect behavior :(");
        assertNotNull(expected.getMessage());
        assertEquals(expectedExString, expected.getMessage());
    }

    @Test
    void saveQuestion_given_nonexistent_org_throws_NotFoundException() {
        Question q = new Question("Hello!", new Session());
        String expectedExString = "Organisation with name: Nonexistent Org not found";
        NotFoundException expected = assertThrows(NotFoundException.class,
                () -> ss.saveQuestion(q,"Nonexistent Org"),
                "Incorrect behavior :(");
        assertNotNull(expected.getMessage());
        assertEquals(expectedExString, expected.getMessage());
    }
}