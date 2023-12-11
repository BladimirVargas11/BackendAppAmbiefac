package ambiefac.back.data;

import ambiefac.back.domain.entities.ClientEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Client extends CrudRepository<ClientEntity, Long> {

}

