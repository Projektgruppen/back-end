package aau.projektgruppen.manova.test.service;

import aau.projektgruppen.manova.exception.NotFoundException;
import aau.projektgruppen.manova.model.Answer;
import aau.projektgruppen.manova.service.RecruiterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RecruiterServiceTests {

    @Autowired
    private RecruiterService rs;

    @Test
    void findReviewedQuestions_given_nonexistent_organisation_throws_NotFoundException() {
        String expectedExString = "Organisation with name: Nonexistent Org not found";
        NotFoundException expected = assertThrows(NotFoundException.class,
                () -> rs.findReviewedQuestions("Nonexistent Org"),
                "Incorrect behavior :(");
        assertNotNull(expected.getMessage());
        assertEquals(expectedExString, expected.getMessage());
    }

    @Test
    void updateAnswer_given_nonexistent_question_id_throws_NotFoundException() {
        Answer a = new Answer("Yeees");
        int qid = Integer.MAX_VALUE;
        String expectedExString = "Could not find a question with id: " + qid;
        NotFoundException expected = assertThrows(NotFoundException.class,
                () -> rs.updateAnswer(a, qid),
                "Incorrect behavior :(");
        assertNotNull(expected.getMessage());
        assertEquals(expectedExString, expected.getMessage());

    }
}