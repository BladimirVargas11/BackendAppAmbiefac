package ambiefac.back.domain.repositories;

import ambiefac.back.data.TopicResponse;

import java.util.List;

public  abstract class TopicRepository {

    public abstract List<TopicResponse> findTopics();
}
