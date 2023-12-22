package ambiefac.back.data;

import ambiefac.back.domain.entities.SubtopicEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Subtopic extends CrudRepository<SubtopicEntity,Long> {

  List<SubtopicEntity> findByTopicId(Long topicId);
}
