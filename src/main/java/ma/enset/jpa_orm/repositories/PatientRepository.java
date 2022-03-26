package ma.enset.jpa_orm.repositories;

import ma.enset.jpa_orm.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
Patient findByNom(String name);
}
