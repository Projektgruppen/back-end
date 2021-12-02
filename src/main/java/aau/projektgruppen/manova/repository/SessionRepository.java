package aau.projektgruppen.manova.repository;

import aau.projektgruppen.manova.model.Session;
import aau.projektgruppen.manova.model.projection.QASessionDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * this class handles all queries regarding {@link aau.projektgruppen.manova.model.Session sessions}. the class is an
 * interface extended from {@link JpaRepository}.
 *
 * @author Tommy Grenaae
 */
public interface SessionRepository extends JpaRepository<Session, Long> {
    @Query("SELECT new aau.projektgruppen.manova.model.projection.QASessionDTO(s.id,s.organisation.id,s.timeOfCreation)"+
            "FROM Session s " +
            "WHERE s.id = :sessionId AND s.organisation.id = :organisationId"
    )
    List<QASessionDTO> findAllSessionsByOrganisationName(long sessionId, long organisationId);

}
