package ambiefac.back.presentation.auth.controllers;

import ambiefac.back.data.Information;
import ambiefac.back.data.Subtopic;
import ambiefac.back.data.request.InformationRequest;
import ambiefac.back.data.request.SubtopicRequest;
import ambiefac.back.data.request.TopicRequest;
import ambiefac.back.data.response.TopicResponse;
import ambiefac.back.domain.dtos.topic.RegisterTopicDto;
import ambiefac.back.domain.entities.*;

import ambiefac.back.domain.repositories.TopicRepository;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;

import java.util.Map;

@RestController
@RequestMapping("/topic")
@Validated
public class TopicController {


    private final TopicRepository topicRepository;
    private final Subtopic subtopicRepository;
    private final Information informationRepository;
    public TopicController(TopicRepository topicRepository, Subtopic subtopicRepository, Information informationRepository) {
        this.topicRepository = topicRepository;
        this.subtopicRepository = subtopicRepository;
        this.informationRepository = informationRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<?> findTopics(){

        return ResponseEntity.status(200).body(this.topicRepository.findTopics());
    }

    @GetMapping("/{cursoId}")
    public ResponseEntity<?> findTopic(@PathVariable Long cursoId){
        TopicResponse result = this.topicRepository.findTopic(cursoId);
        return  ResponseEntity.status(200).body(result);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody  RegisterTopicDto topicEntity, BindingResult bindingResult){

            Map<String, Object> resultado = new HashMap<>();
            TopicEntity topic = topicRepository.save(topicEntity);
            resultado.put("topicId",topic.getId());
            return ResponseEntity.status(200).body(resultado);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            Map<String, Object> resultado = new HashMap<>();
            resultado.put("message",topicRepository.deleteTopic(id));
            return ResponseEntity.status(200).body(resultado);
        }catch (Exception e){
            throw new Error(e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTopic(@PathVariable Long id, @RequestBody TopicEntity topic){
        try{
           TopicEntity topicEntity = topicRepository.updateTopic(id,topic);
           return ResponseEntity.status(201).body(topicEntity);

        }catch (RuntimeException e){
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/saveWitSubtopic")
    public ResponseEntity<?> saveTopic(@RequestBody TopicRequest topicRequest){
       /* TopicEntity topic = convertToTopic(topicRequest);
        this.topicRepository.saveWithSubtopic(topic);
        for(SubtopicRequest subtopicRequest:topicRequest.getSubtopics()){
            SubtopicEntity subtopicEntity = new SubtopicEntity();
            subtopicEntity.setName(subtopicRequest.getNameSubtopic());
            subtopicEntity.setTopic(topic);
            subtopicRepository.save(subtopicEntity);
            for(InformationRequest informationRequest:subtopicRequest.getInformation()){
                InformationEntity informationEntity = new InformationEntity();
                informationEntity.setContent(informationRequest.getInformationContent());
                informationEntity.setHasVideo(informationRequest.getHasVideo());
                informationEntity.setLinkVideo(informationRequest.getLinkVideo());
                informationEntity.setSubtopic(subtopicEntity);
                informationRepository.save(informationEntity);
            }
        }
        return ResponseEntity.status(200).body(topic);
    }

    private TopicEntity convertToTopic(TopicRequest topicRequest) {
        TopicEntity topicEntity = new TopicEntity();
        topicEntity.setName(topicRequest.getTopicName());
        topicEntity.setTime(topicRequest.getTime());
        topicEntity.setDescription(topicRequest.getTopicDescription());

    */
        return null;
    }







}
