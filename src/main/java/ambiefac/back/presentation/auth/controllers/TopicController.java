package ambiefac.back.presentation.auth.controllers;

import ambiefac.back.domain.repositories.TopicRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topic")
@Validated
public class TopicController {


    private final TopicRepository topicRepository;

    public TopicController(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<?> findTopics(){

        return ResponseEntity.status(200).body(this.topicRepository.findTopics());
    }



}
