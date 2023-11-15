package ambiefac.back.domain.datasources;

import ambiefac.back.data.TopicResponse;

import java.util.List;

public abstract class TopicDatasource {

    public abstract List<TopicResponse> findTopics();
}
