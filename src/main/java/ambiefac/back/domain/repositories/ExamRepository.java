package ambiefac.back.domain.repositories;

import ambiefac.back.domain.dtos.exam.RegisterExamDto;

public abstract class ExamRepository {

    public abstract String save(RegisterExamDto examDto);
}
