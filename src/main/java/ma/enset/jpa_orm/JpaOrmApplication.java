package ma.enset.jpa_orm;
import ma.enset.jpa_orm.entities.*;
import ma.enset.jpa_orm.repositories.ConsultationRepository;
import ma.enset.jpa_orm.repositories.MedecinRepository;
import ma.enset.jpa_orm.repositories.PatientRepository;
import ma.enset.jpa_orm.repositories.RendezVousRepository;
import ma.enset.jpa_orm.services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.util.stream.Stream;

import static ma.enset.jpa_orm.entities.StatusRDV.DONE;
import static ma.enset.jpa_orm.entities.StatusRDV.PENDING;


@SpringBootApplication
public class JpaOrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaOrmApplication.class, args);
    }

    @Bean
    CommandLineRunner start(HospitalService hospitalService,PatientRepository patientRepository,
                            RendezVousRepository rendezVousRepository,MedecinRepository medecinRepository) {
        return args -> {
            Stream.of("Omayma", "Ikram", "Imane")
                    .forEach(name -> {
                        Patient patient = new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date(2000, 02, 16));

                        hospitalService.savePatient(patient);
                    });
            Stream.of("khadija", "Ali", "Safaa")
                    .forEach(name -> {
                        Medecin med = new Medecin();
                        med.setNom(name);
                        med.setEmail(name+"@gmail.com");
                        med.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                        hospitalService.saveMedecin(med);
                    });
            Patient patient=patientRepository.findById(1L).orElse( null);
            Patient patient1=patientRepository.findByNom( "Omayma");
            Medecin medecin=medecinRepository.findByNom("Safaa");
            RendezVous rendezVous=new RendezVous ();
            rendezVous.setDate (new Date(2000, 02, 16));
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setMedecin(medecin);
            rendezVous.setPatient (patient);
            hospitalService.saveRDV(rendezVous);

            RendezVous rendezVous1=rendezVousRepository.findAll().get(0);
            Consultation consultation=new Consultation();
            consultation.setDateConsultation (new Date(2022, 02, 16));
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Rapport de la consultion ");
            hospitalService.saveConsultation(consultation);

        };
    }
}