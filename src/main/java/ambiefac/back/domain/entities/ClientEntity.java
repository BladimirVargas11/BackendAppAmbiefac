package ambiefac.back.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @Column(name = "fullName")
    private String fullName;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "credential")
    private CredentialEntity credentials;






    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public CredentialEntity getCredentials() {
        return credentials;
    }

    public void setCredentials(CredentialEntity credentials) {
        this.credentials = credentials;
    }
}
