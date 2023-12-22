package ambiefac.back.infrastructure.repositories;

import ambiefac.back.data.response.AnswersResponse;
import ambiefac.back.data.response.ExamResponse;
import ambiefac.back.domain.datasources.ExamDatasource;
import ambiefac.back.domain.dtos.exam.RegisterExamDto;
import ambiefac.back.domain.dtos.exam.UpdateAnswersListDto;
import ambiefac.back.domain.dtos.exam.UpdateQuestionsListDto;
import ambiefac.back.domain.dtos.exam.ValidAnswersDto;
import ambiefac.back.domain.entities.QuestionAnswerEntity;
import ambiefac.back.domain.repositories.ExamRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public String updateQuestions(UpdateQuestionsListDto updateQuestionsListDto) {
        return examDatasource.updateQuestions(updateQuestionsListDto);
    }

    @Override
    public String updateAnswers(UpdateAnswersListDto updateAnswersListDto) {
        return examDatasource.updateAnswers(updateAnswersListDto);
    }

    @Override
    public AnswersResponse validAnswers(ValidAnswersDto validAnswersDto) {
        return examDatasource.validAnswers(validAnswersDto);
    }

    @Override
    public ExamResponse findQuestionsWithAnswers(Long id) {
        return examDatasource.findQuestionsWithAnswers(id);
    }
}
