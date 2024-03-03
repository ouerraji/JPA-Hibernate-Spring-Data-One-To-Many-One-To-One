package ma.fsac.hospital.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
//mapped by-->cle etrangger generer dans autre classe
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String nom;
    @Temporal(TemporalType.DATE)
    private Date DateNaissance;
    private boolean malade;
    @OneToMany(mappedBy ="patient",fetch = FetchType.LAZY)
private Collection<RendezVous> rendezVous;
}
