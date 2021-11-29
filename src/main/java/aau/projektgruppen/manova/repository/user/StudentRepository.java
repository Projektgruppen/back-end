package aau.projektgruppen.manova.repository.user;

import aau.projektgruppen.manova.model.user.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository <Student, Long> {

}
