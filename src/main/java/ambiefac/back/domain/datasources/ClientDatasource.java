package ambiefac.back.domain.datasources;

import ambiefac.back.domain.entities.ClientEntity;

import java.util.Optional;

public abstract class ClientDatasource {

    public abstract Optional<ClientEntity> getClientById(Long id);
}
