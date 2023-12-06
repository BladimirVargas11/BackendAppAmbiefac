package ambiefac.back.domain.datasources;

import ambiefac.back.data.response.TopicResponse;
import ambiefac.back.domain.entities.TopicEntity;

import java.util.List;

public abstract class TopicDatasource {

    public abstract List<TopicResponse> findTopics();
    public abstract TopicResponse findTopic(Long topicId);

    public abstract TopicEntity saveWithSubtopic(TopicEntity topic);

    public abstract TopicEntity save(TopicEntity topic);
    public abstract  TopicEntity updateTopic(Long id,TopicEntity topic);

    public abstract String deleteTopic(Long id);
}
