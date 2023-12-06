package ambiefac.back.infrastructure.datasources;

import ambiefac.back.data.Topic;
import ambiefac.back.data.response.TopicResponse;
import ambiefac.back.data.TopicSave;
import ambiefac.back.domain.entities.TopicEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TopicDatasource extends ambiefac.back.domain.datasources.TopicDatasource {

    private final Topic topic;
    private final TopicSave topicSave;


    public TopicDatasource(Topic topic, TopicSave topicSave) {
        this.topic = topic;
        this.topicSave = topicSave;

    }


    @Override
    public List<TopicResponse> findTopics() {
        try{
            return topic.findTopic();
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public TopicResponse findTopic(Long topicId) {
        return topic.obtenerInformacionPorCurso(topicId);
    }



    @Override
    public TopicEntity saveWithSubtopic(TopicEntity topic) {
        return topicSave.save(topic);
    }

    @Override
    public TopicEntity save(TopicEntity topic) {
        return topicSave.save(topic);
    }

    @Override
    public TopicEntity updateTopic(Long id, TopicEntity topic) {
        Optional<TopicEntity> topicIsPresent = topicSave.findById(id);
        if (topicIsPresent.isPresent()) {
            topicIsPresent.get().setName(topic.getName());
            topicIsPresent.get().setDescription(topic.getDescription());
            topicIsPresent.get().setTime(topic.getTime());
            return topicSave.save(topicIsPresent.get());
        } else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public String deleteTopic(Long id) {
        Optional<TopicEntity> topicIsPresent = topicSave.findById(id);
        if (topicIsPresent.isPresent()) {
            topicIsPresent.get().setDeleted(true);
           topicSave.save(topicIsPresent.get());
           return "Topic eliminado con exito";
        } else {
            throw new EntityNotFoundException();
        }
    }
}
