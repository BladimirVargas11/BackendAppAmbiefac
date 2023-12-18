package ambiefac.back.infrastructure.repositories;

import ambiefac.back.data.response.ClientTopicResponse;
import ambiefac.back.domain.datasources.ClientTopicDatasource;
import ambiefac.back.domain.dtos.ClientTopic.RegisterClientTopicDto;
import ambiefac.back.domain.entities.ClientTopicEntity;
import ambiefac.back.domain.repositories.ClientTopicRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientTopicRepositoryImp extends ClientTopicRepository {

    private final ClientTopicDatasource clientTopicDatasource;

    public ClientTopicRepositoryImp(ClientTopicDatasource clientTopicDatasource) {
        this.clientTopicDatasource = clientTopicDatasource;
    }

    @Override
    public ClientTopicEntity save(RegisterClientTopicDto registerClientTopicDto) {
        return clientTopicDatasource.save(registerClientTopicDto);
    }

    @Override
    public List<ClientTopicResponse>findCourses(Long id) {
        return clientTopicDatasource.findCourses(id);
    }
}
