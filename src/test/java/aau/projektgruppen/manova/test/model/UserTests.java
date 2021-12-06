package aau.projektgruppen.manova.test.model;

import aau.projektgruppen.manova.model.user.Moderator;
import aau.projektgruppen.manova.model.user.Recruiter;
import aau.projektgruppen.manova.model.user.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTests {

    @Test
    void Student_getId_default_is_not_negative() {
        Student user = new Student();
        assertFalse(user.getId() < 0);
    }

    @Test
    void Recruiter_getId_default_is_not_negative() {
        Recruiter user = new Recruiter();
        assertFalse(user.getId() < 0);
    }

    @Test
    void Moderator_getId_default_is_not_negative() {
        Moderator user = new Moderator();
        assertFalse(user.getId() < 0);
    }
}
