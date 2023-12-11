package ambiefac.back.presentation.auth.controllers;

import ambiefac.back.domain.dtos.exam.RegisterExamDto;
import ambiefac.back.infrastructure.repositories.ExamRepositoryImp;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exam")
@Validated
public class ExamController {

    private final ExamRepositoryImp examRepositoryImp;

    public ExamController(ExamRepositoryImp examRepositoryImp) {
        this.examRepositoryImp = examRepositoryImp;
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody RegisterExamDto registerExamDto){
        return ResponseEntity.status(201).body(examRepositoryImp.save(registerExamDto));
    }
}
