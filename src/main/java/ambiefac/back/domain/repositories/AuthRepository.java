package ambiefac.back.domain.repositories;

import ambiefac.back.domain.entities.CredentialEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface AuthRepository extends CrudRepository<CredentialEntity, Long> {

    Optional<CredentialEntity> findByEmail(String email);

    UserDetails findByUsername(String username);
}
