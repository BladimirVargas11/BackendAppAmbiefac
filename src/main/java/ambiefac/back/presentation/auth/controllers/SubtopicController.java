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
    public ResponseEntity<?> saveSubtopic(@Valid @RequestBody RegisterSubtopicDto subtopic) {
        Map<String, Object> resultado = new HashMap<>();
        SubtopicEntity subtopicEntity = subtopicRepository.save(subtopic);
        resultado.put("topicId", subtopicEntity.getId());
        return ResponseEntity.status(200).body(resultado);
    }

    @GetMapping("byTopic/{id}")
    public ResponseEntity<?> findSubtopicsOfTopic(@PathVariable Long id) {

        Map<String, Object> resultado = new HashMap<>();
        try {
            resultado.put("data", subtopicRepository.findTopicsOfTopic(id));
            resultado.put("success", true);
            resultado.put("message", "Consulta exitosa");
        } catch (Exception e) {
            resultado.put("success", false);
            resultado.put("message", "Error al procesar la consulta: " + e.getMessage());
        }
        return ResponseEntity.ok().body(resultado);

    }

    @PutMapping("update")
    public ResponseEntity<?> updateSubtopicsOfTopic(@RequestBody UpdateSubtopicDto updateSubtopicDto) {
        return ResponseEntity.status(200).body(subtopicRepository.update(updateSubtopicDto));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> Delete(@PathVariable Long id) {
        return ResponseEntity.status(200).body(subtopicRepository.delete(id));

    }
}


