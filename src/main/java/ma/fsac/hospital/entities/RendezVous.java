package ma.fsac.hospital.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class RendezVous {
    // @Id @GeneratedValue(strategy = GenerationType.IDENTITY) -->pour Long ou int...
    @Id
    private String id;
    @Temporal(TemporalType.DATE)
    private Date date;
    @Enumerated(EnumType.STRING)
    private StatusRDV statusRDV;
@ManyToOne
//rendez vous fais appel a patient et patient fait appel a rendez vous (dans le fichier json Rest)..pour ca on ajoute cette annotation
@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
private Patient patient;
@ManyToOne
    private Medecin medecin;
@OneToOne(mappedBy = "rendezVous")
private Consultation consultation;
}
