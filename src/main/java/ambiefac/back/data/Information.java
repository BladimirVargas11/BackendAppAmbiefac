package ambiefac.back.data;

import ambiefac.back.domain.entities.InformationEntity;
import org.springframework.data.repository.CrudRepository;

public interface Information extends CrudRepository<InformationEntity,Long> {
}
