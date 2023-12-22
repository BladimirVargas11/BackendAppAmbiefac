package ambiefac.back.data;

import ambiefac.back.domain.entities.InformationEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Information extends CrudRepository<InformationEntity,Long> {

    List<InformationEntity> findBySubtopicId(Long id);
}
