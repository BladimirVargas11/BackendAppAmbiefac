package ambiefac.back.data;

import ambiefac.back.domain.entities.RoleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Roles extends CrudRepository<RoleEntity, Long> {


}
