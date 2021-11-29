package aau.projektgruppen.manova.test.service;

import aau.projektgruppen.manova.exception.NotFoundException;
import aau.projektgruppen.manova.service.ModeratorService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ModeratorServiceTests {

    @Autowired
    private ModeratorService ms;

    @Test
    public void findUnapprovedSessionQuestions_given_null_throws_NotFoundException() {
        String expectedExString = "No unapproved questions";
        NotFoundException expected = assertThrows(NotFoundException.class,
                () -> ms.findUnapprovedSessionQuestions(null),
                "Incorrect behavior :(");
        assertNotNull(expected.getMessage());
        assertEquals(expectedExString, expected.getMessage());
    }

    @Test // TODO: Possibly useless test
    public void findUnapprovedQuestions_throws_NotFoundException() {
        NotFoundException expected = assertThrows(NotFoundException.class,
                () -> ms.findUnapprovedQuestions());
        assertNotNull(expected.getMessage());
    }

    @Test
    public void approveQuestion_given_nonexistent_id_throws_NotFoundException() {
        NotFoundException expected = assertThrows(NotFoundException.class,
                () -> ms.approveQuestion(Integer.MAX_VALUE),
                "Incorrect behavior :(");
        assertNotNull(expected.getMessage());
    }

    @Test
    public void reviewQuestion_given_nonexistent_id_throws_NotFoundException() {
        NotFoundException expected = assertThrows(NotFoundException.class,
                () -> ms.reviewQuestion(Integer.MAX_VALUE),
                "Incorrect behavior :(");
        assertNotNull(expected.getMessage());
    }

    @Test
    public void toggleSession_given_nonexistent_organisation_throws_NotFoundException() {
        NotFoundException expected = assertThrows(NotFoundException.class,
                () -> ms.toggleSession("OrgNull", "state!?"),
                "Incorrect behavior :(");
        assertNotNull(expected.getMessage());
    }

    @Test
    public void toggleSession_given_bad_state_throws_IllegalStateException() {
        IllegalStateException expected = assertThrows(IllegalStateException.class,
                () -> ms.toggleSession("Politiet", "Foo!"),
                "Bad state was set!");
        assertNotNull(expected.getMessage());
    }

    @Test
    public void toggleSession_given_null_state_throws_IllegalStateException() {
        IllegalStateException expected = assertThrows(IllegalStateException.class,
                () -> ms.toggleSession("Politiet", null),
                "Null state was set!");
        assertNotNull(expected.getMessage());
    }

    @Test
    public void newSession_given_nonexistent_organisation_throws_NotFoundException() {
        NotFoundException expected = assertThrows(NotFoundException.class,
                () -> ms.newSession("This Org does not exist"),
                "Incorrect behavior! :(");
        assertNotNull(expected.getMessage());
    }

    @Test
    public void newOrganisation_given_null_throws_IllegalArgumentException() {
        IllegalArgumentException expected = assertThrows(IllegalArgumentException.class,
                () -> ms.newSession(null),
                "Incorrect behavior! :(");
        assertNotNull(expected.getMessage());
    }
}