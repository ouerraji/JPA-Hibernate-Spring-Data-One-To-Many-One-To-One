package ma.fsac.hospital.repository;

import ma.fsac.hospital.entities.Patient;
import ma.fsac.hospital.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Rendezvousrepository extends JpaRepository<RendezVous,Long> {
}
