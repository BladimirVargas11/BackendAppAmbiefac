package ambiefac.back.domain.datasources;

import ambiefac.back.domain.dtos.exam.RegisterExamDto;

public abstract class ExamDatasource {

    public abstract String save(RegisterExamDto examDto);
}
