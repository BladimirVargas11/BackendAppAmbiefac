package ambiefac.back.presentation.auth.controllers;

import ambiefac.back.data.IClient;
import ambiefac.back.domain.repositories.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
