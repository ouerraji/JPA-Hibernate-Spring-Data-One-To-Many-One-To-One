package ma.fsac.hospital.repository;

import ma.fsac.hospital.entities.Consultation;
import ma.fsac.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  Consultationrepository extends JpaRepository<Consultation,Long> {
}
