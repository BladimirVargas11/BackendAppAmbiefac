package ambiefac.back.presentation.auth.controllers;

import ambiefac.back.domain.dtos.exam.RegisterExamDto;
import ambiefac.back.domain.dtos.exam.UpdateAnswersListDto;
import ambiefac.back.domain.dtos.exam.UpdateQuestionsListDto;
import ambiefac.back.domain.dtos.exam.ValidAnswersDto;
import ambiefac.back.infrastructure.repositories.ExamRepositoryImp;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
        return ResponseEntity.status(200).body(examRepositoryImp.findQuestionsWithAnswers(id));
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

    @PostMapping("valid-answers")
    public ResponseEntity<?> validAnswers(@Valid @RequestBody ValidAnswersDto validAnswersDto){
        return ResponseEntity.status(200).body(examRepositoryImp.validAnswers(validAnswersDto));
    }


}
