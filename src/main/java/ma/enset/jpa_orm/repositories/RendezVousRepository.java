package ma.enset.jpa_orm.repositories;

import ma.enset.jpa_orm.entities.Patient;
import ma.enset.jpa_orm.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous, String> {

}
