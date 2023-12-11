package ambiefac.back.data;

import ambiefac.back.domain.entities.QuestionAnswerEntity;
import org.springframework.data.repository.CrudRepository;

public interface QuestionAnswer extends CrudRepository<QuestionAnswerEntity,Long> {
}
