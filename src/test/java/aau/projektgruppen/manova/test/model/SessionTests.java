package aau.projektgruppen.manova.test.model;

import aau.projektgruppen.manova.model.Organisation;
import aau.projektgruppen.manova.model.Question;
import aau.projektgruppen.manova.model.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link aau.projektgruppen.manova.model.Session} class
 *
 * @author Mathias Gigas
 */
class SessionTests {

    private Session s;

    @BeforeEach
    void setup() {
        s = new Session();
    }

    @Test
    void constructor_given_null_as_org_throws_RuntimeException() {
        RuntimeException thrown = assertThrows(RuntimeException.class,
                () -> s = new Session(null)
                ,"Session was created with no associated Organization");
        assertNotNull(thrown.getMessage());
    }

    @Test
    void isLive_default_is_false() {
        assertFalse(s.isLive());
    }

    @Test
    void setLive_given_true_then_isLive_returns_true() {
        s.setLive(true);
        assertTrue(s.isLive());
    }


    @Test
    void isAutoReview_default_is_false() {
        assertFalse(s.isAutoReview());
    }

    @Test
    void setAutoReview_given_true_then_isAutoReview_returns_true() {
        s.setAutoReview(true);
        assertTrue(s.isAutoReview());
    }

    @Test
    void getOrganisation_default_is_not_null() {
        assertNotNull(s.getOrganisation());
    }

    @Test
    void setOrganisation_given_org_then_getOrganisation_returns_org() {
        Organisation org = new Organisation();
        s.setOrganisation(org);
        assertEquals(org, s.getOrganisation());
    }

    @Test
    void getQuestions_default_is_not_null() {
        assertNotNull(s.getQuestions());
    }

    @Test
    void getQuestions_default_is_empty_list() {
        assertTrue(s.getQuestions().isEmpty());
    }

    @Test
    void setQuestions_given_list_then_getQuestions_returns_list() {
        List<Question> qList = Arrays.asList(
                new Question("foo", this.s),
                new Question("bar", this.s),
                new Question("baz", this.s));

        s.setQuestions(qList);
        assertEquals(qList.get(0), s.getQuestions().get(0));
        assertEquals(qList.get(1), s.getQuestions().get(1));
        assertEquals(qList.get(2), s.getQuestions().get(2));
    }

    @Test
    void getId_default_is_not_negative() {
        assertFalse(s.getId() < 0);
    }

    // --- Possible improvements -----------------------------------------------

    @Test // TODO: Possible improvement
    void toggleLive_default_returns_true() {
        // Feature should be similar as follows
        s.setLive(!s.isLive());
        assertTrue(s.isLive());

        fail("Not implemented");
        //if implemented:
        //assertTrue(s.toggleLive());
    }

    @Test // TODO: Possible improvement
    void toggleAutoReview_default_returns_true() {
        // Feature should be similar as follows
        s.setAutoReview(!s.isAutoReview());
        assertTrue(s.isAutoReview());

        fail("Not implemented");
        //if implemented:
        //assertTrue(s.toggleAutoReview());
    }
}