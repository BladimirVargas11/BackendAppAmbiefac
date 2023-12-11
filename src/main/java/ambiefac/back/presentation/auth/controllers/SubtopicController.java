package ambiefac.back.presentation.auth.controllers;

import ambiefac.back.data.TopicSave;
import ambiefac.back.domain.dtos.subtopic.RegisterSubtopicDto;
import ambiefac.back.domain.entities.SubtopicEntity;
import ambiefac.back.domain.repositories.SubtopicRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/subtopic")
@Validated
public class SubtopicController {

    private final SubtopicRepository subtopicRepository;
    private final TopicSave topicSave;

    public SubtopicController(SubtopicRepository subtopicRepository, TopicSave topicSave) {
        this.subtopicRepository = subtopicRepository;
        this.topicSave = topicSave;
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveSubtopic(@Valid  @RequestBody RegisterSubtopicDto subtopic){
        Map<String, Object> resultado = new HashMap<>();
       SubtopicEntity subtopicEntity = subtopicRepository.save(subtopic);
        resultado.put("topicId",subtopicEntity.getId());
        return ResponseEntity.status(200).body(resultado);
    }
}


