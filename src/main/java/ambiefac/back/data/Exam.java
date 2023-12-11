package ambiefac.back.data;

import ambiefac.back.domain.entities.ExamEntity;
import org.springframework.data.repository.CrudRepository;

public interface Exam extends CrudRepository<ExamEntity,Long> {
}
