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

import ambiefac.back.util.Response;
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
        Response<?> response = new Response<>(true,"Consulta exitosa", this.topicRepository.findTopics());
        return ResponseEntity.status(200).body(response);
    }

    @GetMapping("/{cursoId}")
    public ResponseEntity<?> findTopic(@PathVariable Long cursoId){
        TopicResponse result = this.topicRepository.findTopic(cursoId);
        Response<?> response = new Response<>(true,"Consulta exitosa", result);
        return  ResponseEntity.status(200).body(response);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody  RegisterTopicDto topicEntity, BindingResult bindingResult){

            Map<String, Object> resultado = new HashMap<>();
            TopicEntity topic = topicRepository.save(topicEntity);
            resultado.put("topicId",topic.getId());
        Response<?> response = new Response<>(true,"Registro exitoso", resultado);
            return ResponseEntity.status(200).body(response);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            Map<String, Object> resultado = new HashMap<>();
            resultado.put("message",topicRepository.deleteTopic(id));
            Response<?> response = new Response<>(true,"Eliminacion exitosa", resultado);
            return ResponseEntity.status(200).body(response);
        }catch (Exception e){
            throw new Error(e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTopic(@PathVariable Long id, @RequestBody TopicEntity topic){
        Map<String, Object> resultado = new HashMap<>();
        TopicEntity topicEntity = topicRepository.updateTopic(id,topic);
        resultado.put("topicId",topic);
        Response<?> response = new Response<>(true,"Actualizacion exitosa", resultado);
        return ResponseEntity.status(200).body(response);


    }

    @GetMapping("/search")
    public  ResponseEntity<?> search(@RequestBody String world){
        Map<String, Object> resultado = new HashMap<>();
        var list = topicRepository.search(world);
        resultado.put("list",list);
        Response<?> response = new Response<>(true,"Consulta exitosa", resultado);
        return ResponseEntity.status(200).body(response);
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
