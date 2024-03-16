package ambiefac.back.infrastructure.repositories;

import ambiefac.back.data.response.TopicResponse;
import ambiefac.back.domain.datasources.TopicDatasource;
import ambiefac.back.domain.dtos.topic.RegisterTopicDto;
import ambiefac.back.domain.entities.TopicEntity;
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

  @Override
  public TopicResponse findTopic(Long topicId) {
    return topicDatasource.findTopic(topicId);
  }

  @Override
  public TopicEntity saveWithSubtopic(TopicEntity topic) {
    return topicDatasource.saveWithSubtopic(topic);
  }

  @Override
  public TopicEntity save(RegisterTopicDto topic) {
    return topicDatasource.save(topic);
  }

  @Override
  public TopicEntity updateTopic(Long id, TopicEntity topic) {
    return topicDatasource.updateTopic(id, topic);
  }

  @Override
  public String deleteTopic(Long id) {
    return topicDatasource.deleteTopic(id);
  }

}
