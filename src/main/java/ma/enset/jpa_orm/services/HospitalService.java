package ma.enset.jpa_orm.services;

import ma.enset.jpa_orm.entities.Consultation;
import ma.enset.jpa_orm.entities.Medecin;
import ma.enset.jpa_orm.entities.Patient;
import ma.enset.jpa_orm.entities.RendezVous;

public interface HospitalService {
    Patient savePatient (Patient patient);
    Medecin saveMedecin (Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}
