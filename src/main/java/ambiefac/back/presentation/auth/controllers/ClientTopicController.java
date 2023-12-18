package ambiefac.back.presentation.auth.controllers;

import ambiefac.back.domain.dtos.ClientTopic.RegisterClientTopicDto;
import ambiefac.back.domain.entities.ClientTopicEntity;
import ambiefac.back.domain.repositories.ClientTopicRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client-topic")
public class ClientTopicController {

    @Autowired
    private  ClientTopicRepository clientTopicRepository;

    @PostMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody RegisterClientTopicDto registerClientTopicDto){
        ClientTopicEntity clientTopicEntity = clientTopicRepository.save(registerClientTopicDto);
        return ResponseEntity.status(201).body(clientTopicEntity);
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<?> findCourses(@PathVariable Long id){
        return ResponseEntity.status(200).body(clientTopicRepository.findCourses(id));
    }


}
