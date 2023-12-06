package ambiefac.back.data;

import ambiefac.back.domain.entities.Topic;
import ambiefac.back.domain.entities.TopicEntity;
import org.springframework.data.repository.CrudRepository;

public interface TopicSave extends CrudRepository<TopicEntity,Long> {
}
