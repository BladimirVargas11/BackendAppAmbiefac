package ambiefac.back.domain.datasources;

import ambiefac.back.data.response.ClientTopicResponse;
import ambiefac.back.domain.dtos.ClientTopic.RegisterClientTopicDto;
import ambiefac.back.domain.entities.ClientTopicEntity;

import java.util.List;

public abstract class ClientTopicDatasource {

    public abstract ClientTopicEntity save(RegisterClientTopicDto registerClientTopicDto);

    public abstract List<ClientTopicResponse> findCourses(Long id);
}
