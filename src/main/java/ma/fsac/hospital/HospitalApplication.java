package ma.fsac.hospital;

import ma.fsac.hospital.Services.IHospital;
import ma.fsac.hospital.entities.*;
import ma.fsac.hospital.repository.Consultationrepository;
import ma.fsac.hospital.repository.Medecinrepository;
import ma.fsac.hospital.repository.Patientrepository;
import ma.fsac.hospital.repository.Rendezvousrepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication  {

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

    //injection
    @Bean
    CommandLineRunner start(IHospital hospitalService,Patientrepository patientrepository,Medecinrepository medecinrepository,Rendezvousrepository rendezvousrepository){
        return args -> {
            Stream.of("mohammed","Hassan","Omar").forEach(name->{
                Patient patient=new Patient();
                patient.setNom(name);
                patient.setMalade(true);
                patient.setDateNaissance(new Date());
                hospitalService.savePatient(patient);
            });

            Stream.of("simo","salim","Jamal").forEach(name->{
                Medecin medecin=new Medecin();
                medecin.setNom(name);
                medecin.setEmail(name+"@"+"gmail.com");
                medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                hospitalService.saveMedecin(medecin);

            });
            Patient patient1= patientrepository.findById(1L).orElse(null);
            Patient patient2=patientrepository.findByNom("mohamed");

            Medecin medecin=medecinrepository.findByNom("Jamal");

            RendezVous rendezVous=new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatusRDV(StatusRDV.Pending);
            rendezVous.setMedecin(medecin);
            rendezVous.setPatient(patient1);
            hospitalService.saveRendezVous(rendezVous);



            //RendezVous rendezVous1=rendezvousrepository.findById(1L).orElse(null);
            RendezVous rendezVous1=rendezvousrepository.findAll().get(0);
            Consultation consultation=new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Le rapport est.....");
            hospitalService.saveConsultation(consultation);








        };
    }

}
