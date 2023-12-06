package ambiefac.back.data;

import ambiefac.back.domain.entities.SubtopicEntity;
import org.springframework.data.repository.CrudRepository;

public interface Subtopic extends CrudRepository<SubtopicEntity,Long> {
}
