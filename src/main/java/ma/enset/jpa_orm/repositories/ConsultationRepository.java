package ma.enset.jpa_orm.repositories;

import ma.enset.jpa_orm.entities.Consultation;
import ma.enset.jpa_orm.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

}
