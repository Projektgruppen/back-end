package aau.projektgruppen.manova.repository;

import aau.projektgruppen.manova.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
