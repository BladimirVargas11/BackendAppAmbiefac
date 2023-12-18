package ambiefac.back.presentation.auth.controllers;

import ambiefac.back.data.IClient;
import ambiefac.back.domain.dtos.auth.UpdateClientDto;
import ambiefac.back.domain.entities.ClientEntity;
import ambiefac.back.domain.repositories.ClientRepository;
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
           return ResponseEntity.status(HttpStatus.OK).body(this.clientRepository.findById(id));
       }catch (Exception e){
           return  ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
       }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateClient(@Valid @RequestBody UpdateClientDto updateClientDto, @PathVariable Long id){
        ClientEntity clientEntity = clientRepository.update(updateClientDto,id);
        return ResponseEntity.status(200).body(clientEntity);
    }
}
