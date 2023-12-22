package ambiefac.back.data;

import ambiefac.back.domain.entities.RoleEntity;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    @Autowired
    private Roles roles;

    @PostConstruct
    public void init(){
        try {

            insertRoles();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insertRoles() {

        if (roles.findById(2L).isEmpty()){
            RoleEntity roleClient = new RoleEntity(2,"CLIENT");
            roles.save(roleClient);
        }

        if (roles.findById(1L).isEmpty()){
            RoleEntity roleAdmin = new RoleEntity(1,"ADMIN");
            roles.save(roleAdmin);
        }
    }
}
