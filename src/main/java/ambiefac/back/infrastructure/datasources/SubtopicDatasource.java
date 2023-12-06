package ambiefac.back.infrastructure.datasources;

import ambiefac.back.data.Subtopic;
import ambiefac.back.data.TopicSave;
import ambiefac.back.domain.entities.SubtopicEntity;
import org.springframework.stereotype.Component;

@Component
public class SubtopicDatasource extends ambiefac.back.domain.datasources.SubtopicDatasource {

    private  final Subtopic subtopicService;
    private final TopicSave topicRepository;
    public SubtopicDatasource(Subtopic subtopic, TopicSave topicRepository) {
        this.subtopicService = subtopic;
        this.topicRepository = topicRepository;
    }

    @Override
    public SubtopicEntity save(SubtopicEntity subtopic) {

        try{
            return subtopicService.save(subtopic);
        }catch (RuntimeException e){
            throw new Error(e.getMessage());
        }
    }
}
