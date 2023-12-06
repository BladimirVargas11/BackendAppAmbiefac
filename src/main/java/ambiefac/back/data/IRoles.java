package ambiefac.back.data;

import ambiefac.back.domain.entities.RoleEntity;

import java.util.List;

public interface IRoles {

    List<RoleEntity> findAll();
}
