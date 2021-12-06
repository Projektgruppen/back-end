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
 * Unit tests for the {@link aau.projektgruppen.manova.model.Organisation} class
 *
 * @author Mathias Gigas
 */
public class OrganisationTests {

    Organisation o;

    @BeforeEach
    void setup() {
        o = new Organisation();
    }

    @Test
    void constructor_given_string_returns_Organisation_with_String() {
        o = new Organisation("foo");
        assertEquals("foo", o.getName());
    }

    @Test
    void constructor_given_null_as_name_throws_RuntimeException() {
        RuntimeException thrown = assertThrows(RuntimeException.class,
                () -> new Organisation(null),
                "Organisation possibly created with null name");
        assertNotNull(thrown.getMessage());
    }

    @Test
    void getCurrentSessionId_default_is_Zero() {
        assertEquals(0, o.getCurrentSessionId());
    }

    @Test
    void setCurrentSessionId_then_getCurrentSessionId() {
        o.setCurrentSessionId(100);
        assertEquals(100, o.getCurrentSessionId());
    }

    @Test
    void setSessions_then_getSessions_returns_list() {
        List<Session> sList = Arrays.asList(
                new Session(),
                new Session(),
                new Session());

        o.setSessions(sList);
        assertEquals(sList.get(0), o.getSessions().get(0));
        assertEquals(sList.get(1), o.getSessions().get(1));
        assertEquals(sList.get(2), o.getSessions().get(2));
    }

    @Test
    void getId_default_is_not_negative() {
        assertFalse(o.getId() < 0);
    }

    @Test
    void getName_default_is_not_null() {
        assertNotNull(o.getName());
    }

    @Test
    void setName_then_getName_returns_name() {
        o.setName("foo");
        assertEquals("foo", o.getName());
    }

    @Test
    void toString_contains_name() {
        o.setName("OrgFoo");
        String s = o.toString();
        assertNotNull(s);
        assertTrue(s.contains(o.getName()));
    }
}
