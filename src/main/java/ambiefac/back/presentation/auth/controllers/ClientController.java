package ambiefac.back.presentation.auth.controllers;

import ambiefac.back.data.IClient;
import ambiefac.back.domain.dtos.auth.UpdateClientDto;
import ambiefac.back.domain.entities.ClientEntity;
import ambiefac.back.domain.repositories.ClientRepository;
import ambiefac.back.util.Response;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {

    private  final ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getDetailsUser(@PathVariable Long id){
       try{
           var result = this.clientRepository.findById(id);
           Response<?> response = new Response<>(true,"Consulta exitosa", result);
           return ResponseEntity.status(HttpStatus.OK).body(response);
       }catch (Exception e){
           Response<?> response = new Response<>(false,e.getMessage(), null);
           return  ResponseEntity.status(HttpStatus.CONFLICT).body(response);
       }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateClient(@Valid @RequestBody UpdateClientDto updateClientDto, @PathVariable Long id){
        ClientEntity clientEntity = clientRepository.update(updateClientDto,id);
        Response<?> response = new Response<>(true,"Actualizacion exitosa", clientEntity);
        return ResponseEntity.status(200).body(response);
    }
}
