package ambiefac.back.presentation.auth.controllers;

import ambiefac.back.data.IRoles;
import ambiefac.back.domain.entities.RoleEntity;

import ambiefac.back.util.Response;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
@RequestMapping("/role")
public class RolesController {
	
	@Autowired
    private IRoles roleService;

    public RolesController(IRoles roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getRoles(){
        try{
            Response<?> response = new Response<>(true,"Consulta exitosa",roleService.findAll());
           return  ResponseEntity.status(200).body(response);
        }catch (Exception e){
            throw new  Error(e.getMessage());
        }
    }
    
    @PostMapping("/save")
   
    public ResponseEntity<?> save(@RequestBody @Valid RoleEntity role) {
        Response<?> response = new Response<>(true,"Registro exitoso",roleService.save(role) );
		return ResponseEntity.status(200).body(response);
	}


}
