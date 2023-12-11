package ambiefac.back.data;


import ambiefac.back.domain.entities.TopicEntity;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicSave extends CrudRepository<TopicEntity,Long> {
}
