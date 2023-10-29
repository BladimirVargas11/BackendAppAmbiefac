package ambiefac.back.domain.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "client")
@Data
@NoArgsConstructor
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String fullName;

    @OneToOne
    @JoinColumn(name = "credentialId")
    private CredentialEntity credentials;

}
