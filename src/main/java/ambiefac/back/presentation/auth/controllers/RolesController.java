package ambiefac.back.presentation.auth.controllers;

import ambiefac.back.data.IRoles;
import ambiefac.back.domain.entities.RoleEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RolesController {

    private final IRoles roleService;

    public RolesController(IRoles roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getRoles(){
        try{
           return  ResponseEntity.status(200).body(roleService.findAll());
        }catch (Exception e){
            throw new  Error(e.getMessage());
        }
    }


}
