package ma.fsac.hospital.web;

import ma.fsac.hospital.entities.Patient;
import ma.fsac.hospital.repository.Patientrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRestController {
    @Autowired
    private Patientrepository patientrepository;
    @GetMapping("/patients")
    public List<Patient> patientList(){
       return patientrepository.findAll();
    }
}
