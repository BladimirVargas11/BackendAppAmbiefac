package ambiefac.back.presentation.auth.controllers;

import ambiefac.back.domain.dtos.information.RegisterInformationDto;
import ambiefac.back.domain.dtos.information.RegisterListInformationDto;
import ambiefac.back.domain.entities.InformationEntity;
import ambiefac.back.domain.repositories.InformationRepository;
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

    private final InformationRepository informationRepository;


    public InformationController(InformationRepository informationRepository) {
        this.informationRepository = informationRepository;
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody RegisterListInformationDto informationDto) {

        return ResponseEntity.status(200).body(informationRepository.save(informationDto));

    }
}
