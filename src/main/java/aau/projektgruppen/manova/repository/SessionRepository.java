package aau.projektgruppen.manova.repository;

import aau.projektgruppen.manova.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * this class handles all queries regarding {@link aau.projektgruppen.manova.model.Session sessions}. the class is an
 * interface extended from {@link JpaRepository}.
 *
 * @author Tommy Grenaae
 */
public interface SessionRepository extends JpaRepository<Session, Long> {
}
