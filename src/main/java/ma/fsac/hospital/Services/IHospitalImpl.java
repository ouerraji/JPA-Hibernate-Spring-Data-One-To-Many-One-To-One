package ma.fsac.hospital.Services;

import jakarta.transaction.Transactional;
import ma.fsac.hospital.entities.Consultation;
import ma.fsac.hospital.entities.Medecin;
import ma.fsac.hospital.entities.Patient;
import ma.fsac.hospital.entities.RendezVous;
import ma.fsac.hospital.repository.Consultationrepository;
import ma.fsac.hospital.repository.Medecinrepository;
import ma.fsac.hospital.repository.Patientrepository;
import ma.fsac.hospital.repository.Rendezvousrepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class IHospitalImpl implements IHospital {
    private Patientrepository patientrepository;
    private Medecinrepository medecinrepository;
    private Rendezvousrepository rendezvousrepository;
    private Consultationrepository consultationrepository;

    public IHospitalImpl(Patientrepository patientrepository, Medecinrepository medecinrepository, Rendezvousrepository rendezvousrepository, Consultationrepository consultationrepository) {
        this.patientrepository = patientrepository;
        this.medecinrepository = medecinrepository;
        this.rendezvousrepository = rendezvousrepository;
        this.consultationrepository = consultationrepository;
    }
    // Ou on utilise Autowired (injection des depandances)

    @Override
    public Patient savePatient(Patient patient) {
        return patientrepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinrepository.save(medecin);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezvousrepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationrepository.save(consultation);
    }
}
