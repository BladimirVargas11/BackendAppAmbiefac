package ambiefac.back.presentation.auth.controllers;

import ambiefac.back.data.Information;
import ambiefac.back.data.Subtopic;
import ambiefac.back.data.TopicSave;
import ambiefac.back.data.request.InformationRequestSave;
import ambiefac.back.data.request.SubtopicRequestSave;
import ambiefac.back.domain.entities.InformationEntity;
import ambiefac.back.domain.entities.SubtopicEntity;
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
@RequestMapping("/information")
public class InformationController {

    private final Information informationRepository;
    private final Subtopic subtopicSave;

    public InformationController(Information informationRepository, Subtopic subtopicSave) {
        this.informationRepository = informationRepository;
        this.subtopicSave = subtopicSave;
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody InformationRequestSave informationRequestSave) {
        try {
            Map<String, Object> result = new HashMap<>();
            Optional<SubtopicEntity> subtopic = subtopicSave.findById(informationRequestSave.getIdSubtopic());
            if (subtopic.isPresent()) {
                InformationEntity information = new InformationEntity();
                information.setContent(informationRequestSave.getContent());
                information.setHasVideo(informationRequestSave.getHasVideo());
                information.setLinkVideo(informationRequestSave.getLinkVideo());
                information.setSubtopic(subtopic.get());
                informationRepository.save(information);
                result.put("idInformation", information.getId());
                result.put("idSubtopic", information.getSubtopic().getId());
                return ResponseEntity.status(200).body(result);
            } else {
                result.put("error", "No existe un subtema con ese id");
                return ResponseEntity.status(400).body(result);
            }
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }
}
