package ambiefac.back.domain.repositories;

import ambiefac.back.data.response.TopicResponse;
import ambiefac.back.domain.dtos.topic.RegisterTopicDto;
import ambiefac.back.domain.entities.TopicEntity;

import java.util.List;

public  abstract class TopicRepository {

    public abstract List<TopicResponse> findTopics();

    public abstract TopicResponse findTopic(Long topicId);

    public abstract TopicEntity saveWithSubtopic(TopicEntity topic);

    public abstract TopicEntity save(RegisterTopicDto topic);

    public abstract  TopicEntity updateTopic(Long id,TopicEntity topic);

    public abstract String deleteTopic(Long id);
    public abstract List<TopicResponse> search(String world);

}
