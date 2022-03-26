package ma.enset.jpa_orm.repositories;

import ma.enset.jpa_orm.entities.Medecin;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
   Medecin findByNom(String name);
}
