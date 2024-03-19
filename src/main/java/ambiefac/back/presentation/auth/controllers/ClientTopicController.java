package ambiefac.back.presentation.auth.controllers;

import ambiefac.back.domain.dtos.ClientTopic.RegisterClientTopicDto;
import ambiefac.back.domain.entities.ClientTopicEntity;
import ambiefac.back.domain.repositories.ClientTopicRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/client-topic")
public class ClientTopicController {

    @Autowired
    private ClientTopicRepository clientTopicRepository;

    @PostMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody RegisterClientTopicDto registerClientTopicDto) {
        ClientTopicEntity clientTopicEntity = clientTopicRepository.save(registerClientTopicDto);
        return ResponseEntity.status(201).body(clientTopicEntity);
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<?> findCourses(@PathVariable Long id) {
        Map<String, Object> resultado = new HashMap<>();
        try {
            var list = clientTopicRepository.findCourses(id);
            resultado.put("data", list);
            resultado.put("success", true);
            resultado.put("message", "Consulta exitosa");
        } catch (Exception e) {
            resultado.put("success", false);
            resultado.put("message", "Error al procesar la consulta: " + e.getMessage());
        }
        return ResponseEntity.ok().body(resultado);
    }

    @GetMapping("/courses/{id}/{id_curse}")
    public ResponseEntity<?> validate(@PathVariable Long id,@PathVariable Long id_curse) {
        Map<String, Object> resultado = new HashMap<>();
        try {
            var list = clientTopicRepository.validate(id, id_curse);
            resultado.put("data", list);
            resultado.put("success", true);
            resultado.put("message", "Consulta exitosa");
        } catch (Exception e) {
            resultado.put("success", false);
            resultado.put("message", "Error al procesar la consulta: " + e.getMessage());
        }
        return ResponseEntity.ok().body(resultado);
    }
}
