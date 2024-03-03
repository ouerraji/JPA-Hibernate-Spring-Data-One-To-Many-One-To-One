package ma.fsac.hospital.repository;

import ma.fsac.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Patientrepository extends JpaRepository<Patient,Long> {
    Patient findByNom(String nom);
}
