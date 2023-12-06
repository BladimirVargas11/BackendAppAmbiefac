package ambiefac.back.presentation.auth.controllers;

import ambiefac.back.data.Subtopic;
import ambiefac.back.data.TopicSave;
import ambiefac.back.data.request.SubtopicRequestSave;
import ambiefac.back.domain.entities.SubtopicEntity;
import ambiefac.back.domain.entities.Topic;
import ambiefac.back.domain.entities.TopicEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/subtopic")
public class SubtopicController {

    private final Subtopic subtopicRepository;
    private final TopicSave topicSave;

    public SubtopicController(Subtopic subtopicRepository, TopicSave topicSave) {
        this.subtopicRepository = subtopicRepository;
        this.topicSave = topicSave;
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveSubtopic(@RequestBody SubtopicRequestSave subtopic){
       try{
           Map<String, Object> result = new HashMap<>();
           Optional<TopicEntity> topic = topicSave.findById(subtopic.getIdTopic());
           if(topic.isPresent()){
               SubtopicEntity subtopicEntity = new SubtopicEntity();
               subtopicEntity.setName(subtopic.getName());
               subtopicEntity.setTopic(topic.get());
               subtopicRepository.save(subtopicEntity);
               result.put("idSubtopic",subtopicEntity.getId());
               return ResponseEntity.status(200).body(result);
           }else{
               result.put("error","No existe un tema con ese id");
               return ResponseEntity.status(400).body(result);
           }

       }catch (RuntimeException e){
           throw new Error(e.getMessage());
       }
    }
}


