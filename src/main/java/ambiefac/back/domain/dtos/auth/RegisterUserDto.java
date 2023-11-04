package ambiefac.back.domain.dtos.auth;

import ambiefac.back.domain.entities.ClientEntity;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;

import java.util.Collection;
import java.util.List;

@Data
public class RegisterUserDto implements UserDetails {

    @NotNull(message = "username invalid")
    @Column(unique = true)
    private  String username;
    @Email(message = "Email invalid")
    @NotNull
    private  String email;
    @NotNull(message = "password invalid")
    @Size(min = 6,message = "password invalid")
    private String password;
    @NotNull
    private ClientEntity client;


public RegisterUserDto(){}
public RegisterUserDto(String username, String email, String password, ClientEntity client){
    this.username = username;
    this.password = password;
    this.email = email;
    this.client = client;
}

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("CLIENT"));
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
