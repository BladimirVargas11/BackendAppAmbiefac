package ambiefac.back.domain.repositories;

import ambiefac.back.domain.dtos.auth.ClientDto;
import ambiefac.back.domain.dtos.auth.UpdateClientDto;
import ambiefac.back.domain.entities.ClientEntity;

import java.util.Optional;

public abstract class ClientRepository {

    public abstract Optional<ClientEntity> findById(Long id);
    public abstract ClientEntity update(UpdateClientDto updateClientDto,Long id);

}
