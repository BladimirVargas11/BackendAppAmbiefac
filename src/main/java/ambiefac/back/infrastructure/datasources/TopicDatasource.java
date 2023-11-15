package ambiefac.back.infrastructure.datasources;

import ambiefac.back.data.Topic;
import ambiefac.back.data.TopicResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TopicDatasource extends ambiefac.back.domain.datasources.TopicDatasource {

    private final Topic topic;

    public TopicDatasource(Topic topic) {
        this.topic = topic;
    }


    @Override
    public List<TopicResponse> findTopics() {
        try{
            return topic.findTopic();
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
