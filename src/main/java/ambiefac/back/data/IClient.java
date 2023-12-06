package ambiefac.back.data;

import ambiefac.back.domain.entities.ClientEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface IClient {

    Optional<ClientEntity> findById(Long id);
}
