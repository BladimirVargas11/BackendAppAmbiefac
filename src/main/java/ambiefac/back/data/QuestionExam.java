package ambiefac.back.data;

import ambiefac.back.domain.entities.ExamQuestionEntity;
import org.springframework.data.repository.CrudRepository;

public interface QuestionExam extends CrudRepository<ExamQuestionEntity,Long> {
}
