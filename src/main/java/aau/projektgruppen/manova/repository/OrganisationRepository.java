package aau.projektgruppen.manova.repository;

import aau.projektgruppen.manova.model.Organisation;
import aau.projektgruppen.manova.repository.user.ModeratorRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * This interface handles all queries regarding {@link aau.projektgruppen.manova.model.Organisation organisations}.
 * It is extended from {@link JpaRepository}.
 *
 * @author Tommy Grenaae
 */
public interface OrganisationRepository extends JpaRepository<Organisation, Long> {
    /**
     * Finds an organisation by its name.
     * @param name, a {@code String} indicating the organisation's name.
     * @return An {@link Organisation Organisation} object.
     */
    @Query("select o from Organisation o where o.name = ?1")
    Organisation findByName(String name);

}
