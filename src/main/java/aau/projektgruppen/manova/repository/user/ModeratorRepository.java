package aau.projektgruppen.manova.repository.user;

import aau.projektgruppen.manova.model.user.Moderator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ModeratorRepository extends JpaRepository <Moderator, Long> {
    @Query(value = "SELECT * FROM Moderator WHERE approve = false", nativeQuery = true)
    List<Moderator> getAllUnapprovedQAMessages();
}
