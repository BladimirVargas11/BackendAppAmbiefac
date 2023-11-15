package ambiefac.back.infrastructure.repositories;

import ambiefac.back.data.TopicResponse;
import ambiefac.back.domain.datasources.TopicDatasource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicRepositoryImpl extends ambiefac.back.domain.repositories.TopicRepository {


  @Autowired
  private TopicDatasource topicDatasource;
    @Override
    public List<TopicResponse> findTopics() {
        return topicDatasource.findTopics();
    }
}
