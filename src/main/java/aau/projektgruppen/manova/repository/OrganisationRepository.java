package aau.projektgruppen.manova.repository;

import aau.projektgruppen.manova.model.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganisationRepository extends JpaRepository<Organisation, Long> {
    Organisation findByName(String name);
}