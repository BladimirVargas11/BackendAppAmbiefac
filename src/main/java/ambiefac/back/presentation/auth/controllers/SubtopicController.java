package ambiefac.back.presentation.auth.controllers;

import ambiefac.back.data.TopicSave;
import ambiefac.back.domain.dtos.subtopic.RegisterSubtopicDto;
import ambiefac.back.domain.dtos.subtopic.UpdateSubtopicDto;
import ambiefac.back.domain.entities.SubtopicEntity;
import ambiefac.back.domain.repositories.SubtopicRepository;
import ambiefac.back.util.Response;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
        Response<?> response = new Response<>(true,"Consulta exitosa", resultado);
        return ResponseEntity.status(200).body(response);
    }

    @GetMapping("byTopic/{id}")
    public ResponseEntity<?> findSubtopicsOfTopic(@PathVariable Long id){
        Response<?> response = new Response<>(true,"Consulta exitosa", subtopicRepository.findTopicsOfTopic(id));
        return ResponseEntity.status(200).body(response);
    }

    @PutMapping("update")
    public ResponseEntity<?> updateSubtopicsOfTopic(@RequestBody UpdateSubtopicDto updateSubtopicDto){
        Response<?> response = new Response<>(true,"Actualizacion exitosa", subtopicRepository.update(updateSubtopicDto));
        return ResponseEntity.status(200).body(response);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> Delete(@PathVariable Long id){
        Response<?> response = new Response<>(true,"Consulta exitosa", subtopicRepository.delete(id));
        return ResponseEntity.status(200).body(response);
    }
}


