package ambiefac.back.presentation.auth.controllers;

import ambiefac.back.domain.dtos.exam.*;
import ambiefac.back.infrastructure.repositories.ExamRepositoryImp;
import ambiefac.back.util.Response;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/exam")
@Validated
public class ExamController {

    private final ExamRepositoryImp examRepositoryImp;

    public ExamController(ExamRepositoryImp examRepositoryImp) {
        this.examRepositoryImp = examRepositoryImp;
    }

    @GetMapping("questions/{id}")
    public ResponseEntity<?> findQuestionsWithAnswers(@PathVariable Long id){

        Map<String, Object> resultado = new HashMap<>();
        try {
            resultado.put("data", examRepositoryImp.findQuestionsWithAnswers(id));
            resultado.put("success", true);
            resultado.put("message", "Consulta exitosa");
        } catch (Exception e) {
            resultado.put("success", false);
            resultado.put("message", "Error al procesar la consulta: " + e.getMessage());
        }
        return ResponseEntity.ok().body(resultado);

    }
    @PostMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody RegisterExamDto registerExamDto){
        Response<?> response = new Response<>(true,"Registro exitoso", examRepositoryImp.save(registerExamDto));
        return ResponseEntity.status(201).body(response);
    }

    @PutMapping("/update-questions")
    public ResponseEntity<?> updateQuestions(@Valid @RequestBody UpdateQuestionsListDto updateQuestionsListDto){
        Response<?> response = new Response<>(true,"Actualizacion exitosa", examRepositoryImp.updateQuestions(updateQuestionsListDto));
        return ResponseEntity.status(200).body(response);
    }

    @PutMapping("/update-answers")
    public ResponseEntity<?> updateAnswers(@Valid @RequestBody UpdateAnswersListDto updateAnswersListDto){
        Response<?> response = new Response<>(true,"Actualizacion exitosa", examRepositoryImp.updateAnswers(updateAnswersListDto));
        return ResponseEntity.status(200).body(response);
    }

    //blvargas
    @PostMapping("valid-answers/{id}")
    public ResponseEntity<?> validAnswers(@Valid @RequestBody ValidAnswersDto validAnswersDto){

        Map<String, Object> resultado = new HashMap<>();
        try {
            resultado.put("data", examRepositoryImp.validAnswers(validAnswersDto));
            resultado.put("success", true);
            resultado.put("message", "Consulta exitosa");
        } catch (Exception e) {
            resultado.put("success", false);
            resultado.put("message", "Error al procesar la consulta: " + e.getMessage());
        }
        return ResponseEntity.ok().body(resultado);


    }

    @PostMapping("new-questions/{id}")
    public ResponseEntity<?> registerNewQuestions(@Valid @PathVariable Long id,
                                                  @RequestBody RegisterQuestionDto registerQuestionDto){
        Response<?> response = new Response<>(true,"Registro exitoso", examRepositoryImp.saveNewQuestions(id, registerQuestionDto));
        return ResponseEntity.status(200).body(response);
    }

    @PostMapping("new-answers")
    public ResponseEntity<?> registerNewAnswers(@RequestBody List<RegisterNewAnswerDto> registerAnswersDto){
        Response<?> response = new Response<>(true,"Registro exitoso", examRepositoryImp.saveNewAnswer(registerAnswersDto));
        return ResponseEntity.status(200).body(response);
    }

    @DeleteMapping("delete-question/{id}")
    public ResponseEntity<?> DeleteQuestion(@PathVariable Long id){
        Response<?> response = new Response<>(true,"Eliminacion exitosa", examRepositoryImp.Deletequestion(id));
        return ResponseEntity.status(200).body(response);
    }

    @DeleteMapping("delete-answer/{id}")
    public ResponseEntity<?> DeleteAnswer(@PathVariable Long id){
        Response<?> response = new Response<>(true,"Eliminacion exitosa", examRepositoryImp.deleteAnswer(id));
        return ResponseEntity.status(200).body(response);
    }


}
