package ambiefac.back.infrastructure.datasources;

import ambiefac.back.data.Subtopic;
import ambiefac.back.data.TopicSave;
import ambiefac.back.domain.dtos.subtopic.RegisterSubtopicDto;
import ambiefac.back.domain.entities.SubtopicEntity;
import ambiefac.back.domain.entities.TopicEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SubtopicDatasource extends ambiefac.back.domain.datasources.SubtopicDatasource {

    private  final Subtopic subtopicRepository;
    private final TopicSave topicRepository;
    public SubtopicDatasource(Subtopic subtopic, TopicSave topicRepository) {
        this.subtopicRepository = subtopic;
        this.topicRepository = topicRepository;
    }

    @Override
    public SubtopicEntity save(RegisterSubtopicDto subtopic) {

            Optional<TopicEntity> topic = topicRepository.findById(subtopic.getIdTopic());
            if(topic.isPresent()){
                SubtopicEntity subtopicEntity = new SubtopicEntity();
                subtopicEntity.setName(subtopic.getName());
                subtopicEntity.setTopic(topic.get());
                subtopicRepository.save(subtopicEntity);
                return subtopicEntity;
            }else{
                return null;
            }



    }
}
