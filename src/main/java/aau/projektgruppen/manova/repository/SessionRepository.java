package aau.projektgruppen.manova.repository;

import aau.projektgruppen.manova.model.Session;
import aau.projektgruppen.manova.model.projection.QASessionDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * This interface handles all queries regarding {@link aau.projektgruppen.manova.model.Session sessions}. It is extended from {@link JpaRepository}.
 *
 */
public interface SessionRepository extends JpaRepository<Session, Long> {
    @Query("SELECT new aau.projektgruppen.manova.model.projection.QASessionDTO(s.id,s.organisation.id,s.timeOfCreation)"+
            "FROM Session s " +
            "WHERE s.organisation.id = :organisationId"
    )
    List<QASessionDTO> findAllSessionsByOrganisationName(long organisationId);

}
