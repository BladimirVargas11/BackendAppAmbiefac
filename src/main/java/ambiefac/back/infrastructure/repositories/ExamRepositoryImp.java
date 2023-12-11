package ambiefac.back.infrastructure.repositories;

import ambiefac.back.domain.datasources.ExamDatasource;
import ambiefac.back.domain.dtos.exam.RegisterExamDto;
import ambiefac.back.domain.repositories.ExamRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ExamRepositoryImp extends ExamRepository {

    private final ExamDatasource examDatasource;

    public ExamRepositoryImp(ExamDatasource examDatasource) {
        this.examDatasource = examDatasource;
    }

    @Override
    public String save(RegisterExamDto examDto) {
        return examDatasource.save(examDto);
    }
}
