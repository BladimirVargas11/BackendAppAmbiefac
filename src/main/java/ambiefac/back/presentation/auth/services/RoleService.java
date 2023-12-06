package ambiefac.back.presentation.auth.services;

import ambiefac.back.data.IRoles;
import ambiefac.back.data.Roles;
import ambiefac.back.domain.entities.RoleEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService  implements IRoles {

    private final Roles roleRepositoy;

    public RoleService(Roles roleRepositoy) {
        this.roleRepositoy = roleRepositoy;
    }


    @Override
    public List<RoleEntity> findAll() {
        return (List<RoleEntity>) roleRepositoy.findAll();
    }
}
