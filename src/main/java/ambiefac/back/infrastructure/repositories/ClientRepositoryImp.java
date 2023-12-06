package ambiefac.back.infrastructure.repositories;

import ambiefac.back.domain.dtos.auth.ClientDto;
import ambiefac.back.domain.entities.ClientEntity;
import ambiefac.back.domain.repositories.ClientRepository;
import ambiefac.back.infrastructure.datasources.ClientDatasource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientRepositoryImp extends ClientRepository {
    @Autowired
    private final ClientDatasource clientDatasource;

    public ClientRepositoryImp(ClientDatasource clientDatasource) {
        this.clientDatasource = clientDatasource;
    }



    @Override
    public Optional<ClientEntity> findById(Long id) {
        return clientDatasource.getClientById(id);
    }
}
