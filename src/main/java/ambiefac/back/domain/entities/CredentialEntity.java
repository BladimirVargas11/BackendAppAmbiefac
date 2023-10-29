package ambiefac.back.domain.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.management.relation.Role;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "credential")
@Data
@NoArgsConstructor
public class CredentialEntity  {

    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long credentialId;
    private String username;
    private  String password;
    private String email;
    private String JWT;

    public CredentialEntity(Long credentialId, String username, String password, String email, String JWT) {
        this.credentialId = credentialId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.JWT = JWT;
    }



}
