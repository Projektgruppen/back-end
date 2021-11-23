package com.example.demo.test;

import com.example.demo.model.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SessionTests {

    private Session s;

    @BeforeEach
    void setup() {
        s = new Session();
    }

    @Test
    void getIdNotNull() {
        assertNotNull(s.getId());
    }

    @Test
    void getIdGreaterThanZero() {
        assertTrue(s.getId() > 0);
    }

    @Test // TODO: FIX
    void newSessionWithNegativeIdThrowsException() {
        /* NumberFormatException thrown = assertThrows(NumberFormatException.class,
                () -> s = new Session(-1L)
                ,"ID was set to negative value!"); // In case no exception is thrown show this.
        assertNotNull(thrown.getMessage());*/
    }

    @Test
    void getOrgIdNotLessThanZero() {
        s = new Session();
        assertFalse(true); //s.getOrgId() < 0);
    }
}
