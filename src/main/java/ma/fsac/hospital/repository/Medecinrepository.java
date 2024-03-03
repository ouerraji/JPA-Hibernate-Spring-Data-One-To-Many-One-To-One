package ma.fsac.hospital.repository;

import ma.fsac.hospital.entities.Medecin;
import ma.fsac.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Medecinrepository extends JpaRepository<Medecin,Long> {
    Medecin findByNom(String nom);
}
