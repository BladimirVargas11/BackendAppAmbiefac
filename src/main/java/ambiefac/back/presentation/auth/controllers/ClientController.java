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

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/client")
public class ClientController {

    private  final ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getDetailsUser(@PathVariable Long id){
        Map<String, Object> resultado = new HashMap<>();
        try {
            resultado.put("data", clientRepository.findById(id));
            resultado.put("success", true);
            resultado.put("message", "Consulta exitosa");
        } catch (Exception e) {
            resultado.put("success", false);
            resultado.put("message", "Error al procesar la consulta: " + e.getMessage());
        }
        return ResponseEntity.ok().body(resultado);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateClient(@Valid @RequestBody UpdateClientDto updateClientDto, @PathVariable Long id){
        ClientEntity clientEntity = clientRepository.update(updateClientDto,id);
        Response<?> response = new Response<>(true,"Actualizacion exitosa", clientEntity);
        return ResponseEntity.status(200).body(response);
    }
}
