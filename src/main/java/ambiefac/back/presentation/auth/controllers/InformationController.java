package ambiefac.back.presentation.auth.controllers;

import ambiefac.back.domain.dtos.information.RegisterInformationDto;
import ambiefac.back.domain.dtos.information.RegisterListInformationDto;
import ambiefac.back.domain.dtos.information.UpdateListInformationDto;
import ambiefac.back.domain.entities.InformationEntity;
import ambiefac.back.domain.repositories.InformationRepository;
import ambiefac.back.util.Response;
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
        Response<?> response = new Response<>(true,"Registro exitoso", informationRepository.save(informationDto));
        return ResponseEntity.status(200).body(response);

    }

    @GetMapping("bySubtopic/{id}")
    public ResponseEntity<?> findInformationOfSubtopic(@PathVariable Long id){

        Map<String, Object> resultado = new HashMap<>();
        try {
            resultado.put("data", informationRepository.findInformationOfSubtopic(id));
            resultado.put("success", true);
            resultado.put("message", "Consulta exitosa");
        } catch (Exception e) {
            resultado.put("success", false);
            resultado.put("message", "Error al procesar la consulta: " + e.getMessage());
        }
        return ResponseEntity.ok().body(resultado);

    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody UpdateListInformationDto updateListInformationDto) {
        Response<?> response = new Response<>(true,"Actualizacion exitosa", informationRepository.updateInformation(updateListInformationDto));
        return ResponseEntity.status(200).body(response);

    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteInformation(@PathVariable Long id){
        Response<?> response = new Response<>(true,"Eliminacion exitosa", informationRepository.deleteInformation(id));
        return ResponseEntity.status(200).body(response);
    }
}
