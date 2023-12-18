package ambiefac.back.infrastructure.datasources;

import ambiefac.back.data.IClient;
import ambiefac.back.domain.dtos.auth.UpdateClientDto;
import ambiefac.back.domain.entities.ClientEntity;
import jakarta.persistence.EntityNotFoundException;
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

    @Override
    public ClientEntity update(UpdateClientDto updateClientDto,Long id) {
        Optional<ClientEntity> clientEntity = clientRepository.findById(id);
        if(clientEntity.isPresent()){
            clientEntity.get().setFullName(updateClientDto.getFullName());
            clientRepository.save(clientEntity.get());
            return clientEntity.get();
        }else{
            throw new EntityNotFoundException("No existe un cliente con este id");
        }
    }
}
