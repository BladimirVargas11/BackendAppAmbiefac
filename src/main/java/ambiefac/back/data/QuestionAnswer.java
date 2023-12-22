package ambiefac.back.data;

import ambiefac.back.domain.entities.QuestionAnswerEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionAnswer extends CrudRepository<QuestionAnswerEntity,Long> {

    List<QuestionAnswerEntity> findByQuestionId(Long id);
}
