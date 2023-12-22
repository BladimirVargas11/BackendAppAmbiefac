package ambiefac.back.presentation.auth.controllers;

import ambiefac.back.domain.dtos.information.RegisterInformationDto;
import ambiefac.back.domain.dtos.information.RegisterListInformationDto;
import ambiefac.back.domain.dtos.information.UpdateListInformationDto;
import ambiefac.back.domain.entities.InformationEntity;
import ambiefac.back.domain.repositories.InformationRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/information")
public class InformationController {

    private final InformationRepository informationRepository;


    public InformationController(InformationRepository informationRepository) {
        this.informationRepository = informationRepository;
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody RegisterListInformationDto informationDto) {

        return ResponseEntity.status(200).body(informationRepository.save(informationDto));

    }

    @GetMapping("bySubtopic/{id}")
    public ResponseEntity<?> findInformationOfSubtopic(@PathVariable Long id){
        return ResponseEntity.status(200).body(informationRepository.findInformationOfSubtopic(id));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody UpdateListInformationDto updateListInformationDto) {
        return ResponseEntity.status(200).body(informationRepository.updateInformation(updateListInformationDto));

    }
}
