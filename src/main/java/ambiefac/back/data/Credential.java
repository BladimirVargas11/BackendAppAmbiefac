package ambiefac.back.data;

import ambiefac.back.domain.entities.CredentialEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Credential extends CrudRepository<CredentialEntity, Long> {

    Optional<CredentialEntity> findByEmail(String email);

    UserDetails findByUsername(String username);


}
