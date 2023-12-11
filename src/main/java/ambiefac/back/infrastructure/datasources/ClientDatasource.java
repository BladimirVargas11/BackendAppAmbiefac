package ambiefac.back.infrastructure.datasources;

import ambiefac.back.data.IClient;
import ambiefac.back.domain.entities.ClientEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ClientDatasource extends ambiefac.back.domain.datasources.ClientDatasource {

    private final IClient clientRepository;


    public ClientDatasource(IClient clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public Optional<ClientEntity> getClientById(Long id) {
        try{
            return this.clientRepository.findById(id);
        }catch (RuntimeException e){
            throw new Error(e.getMessage());
        }
    }
}
