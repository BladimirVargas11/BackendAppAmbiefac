package ambiefac.back.presentation.auth.services;

import ambiefac.back.data.Client;
import ambiefac.back.data.IClient;
import ambiefac.back.domain.entities.ClientEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService implements IClient {

    private final Client clientRepository;

    public ClientService(Client clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Optional<ClientEntity> findById(Long id) {
        return clientRepository.findById(id);
    }
}
