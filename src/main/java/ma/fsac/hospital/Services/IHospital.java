package ma.fsac.hospital.Services;

import ma.fsac.hospital.entities.Consultation;
import ma.fsac.hospital.entities.Medecin;
import ma.fsac.hospital.entities.Patient;
import ma.fsac.hospital.entities.RendezVous;

public interface IHospital {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRendezVous(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}
