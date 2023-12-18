package ambiefac.back.infrastructure.datasources;

import ambiefac.back.data.Client;
import ambiefac.back.data.ClientTopic;
import ambiefac.back.data.ClientTopicList;
import ambiefac.back.data.TopicSave;
import ambiefac.back.data.response.ClientTopicResponse;
import ambiefac.back.domain.datasources.ClientTopicDatasource;
import ambiefac.back.domain.dtos.ClientTopic.RegisterClientTopicDto;
import ambiefac.back.domain.entities.ClientEntity;
import ambiefac.back.domain.entities.ClientTopicEntity;
import ambiefac.back.domain.entities.TopicEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientTopicDatasourceImp extends ClientTopicDatasource {

    private final TopicSave topic;
    private final Client client;
    private final ClientTopic clientTopic;
    private final ClientTopicList clientTopicList;


    public ClientTopicDatasourceImp(TopicSave topic, Client client, ClientTopic clientTopic, ClientTopicList clientTopicList) {
        this.topic = topic;
        this.client = client;
        this.clientTopic = clientTopic;
        this.clientTopicList = clientTopicList;
    }

    @Override
    public ClientTopicEntity save(RegisterClientTopicDto registerClientTopicDto) {

        Optional<ClientEntity> clientEntity = client.findById(registerClientTopicDto.getIdClient());
        if(clientTopic.existsByClientIdAndTopicId(registerClientTopicDto.getIdClient(),registerClientTopicDto.getIdTopic())){
            throw new RuntimeException("Ya esta registrado en este curso");
        }else{
            if(clientEntity.isPresent()){
                Optional<TopicEntity> topicEntity = topic.findById(registerClientTopicDto.getIdTopic());
                if(topicEntity.isPresent()){
                    ClientTopicEntity clientTopicEntity = new ClientTopicEntity();
                    clientTopicEntity.setClient(clientEntity.get());
                    clientTopicEntity.setTopic(topicEntity.get());

                    return clientTopic.save(clientTopicEntity);
                }else{
                    throw new EntityNotFoundException("No existe un topic con este id");
                }
            }else{
                throw new EntityNotFoundException("No existe un cliente con este id");
            }
        }


    }

    @Override
    public List<ClientTopicResponse> findCourses(Long id) {
        try {
            return clientTopicList.getClientCourses(id);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
