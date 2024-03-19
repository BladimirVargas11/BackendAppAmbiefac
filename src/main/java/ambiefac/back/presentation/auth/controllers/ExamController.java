package ambiefac.back.presentation.auth.controllers;

import ambiefac.back.domain.dtos.exam.*;
import ambiefac.back.infrastructure.repositories.ExamRepositoryImp;
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
        return ResponseEntity.status(201).body(examRepositoryImp.save(registerExamDto));
    }

    @PutMapping("/update-questions")
    public ResponseEntity<?> updateQuestions(@Valid @RequestBody UpdateQuestionsListDto updateQuestionsListDto){
        return ResponseEntity.status(200).body(examRepositoryImp.updateQuestions(updateQuestionsListDto));
    }

    @PutMapping("/update-answers")
    public ResponseEntity<?> updateAnswers(@Valid @RequestBody UpdateAnswersListDto updateAnswersListDto){
        return ResponseEntity.status(200).body(examRepositoryImp.updateAnswers(updateAnswersListDto));
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
        return ResponseEntity.status(200).body(examRepositoryImp.saveNewQuestions(id, registerQuestionDto));
    }

    @PostMapping("new-answers")
    public ResponseEntity<?> registerNewAnswers(@RequestBody List<RegisterNewAnswerDto> registerAnswersDto){
        return ResponseEntity.status(200).body(examRepositoryImp.saveNewAnswer(registerAnswersDto));
    }

    @DeleteMapping("delete-question/{id}")
    public ResponseEntity<?> DeleteQuestion(@PathVariable Long id){
        return ResponseEntity.status(200).body(examRepositoryImp.Deletequestion(id));
    }

    @DeleteMapping("delete-answer/{id}")
    public ResponseEntity<?> DeleteAnswer(@PathVariable Long id){
        return ResponseEntity.status(200).body(examRepositoryImp.deleteAnswer(id));
    }


}
