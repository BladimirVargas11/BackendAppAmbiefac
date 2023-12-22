package ambiefac.back.domain.repositories;

import ambiefac.back.data.response.AnswersResponse;
import ambiefac.back.data.response.ExamResponse;
import ambiefac.back.domain.dtos.exam.RegisterExamDto;
import ambiefac.back.domain.dtos.exam.UpdateAnswersListDto;
import ambiefac.back.domain.dtos.exam.UpdateQuestionsListDto;
import ambiefac.back.domain.dtos.exam.ValidAnswersDto;
import ambiefac.back.domain.entities.QuestionAnswerEntity;

import java.util.List;

public abstract class ExamRepository {

    public abstract String save(RegisterExamDto examDto);
    public abstract String updateQuestions(UpdateQuestionsListDto updateQuestionsListDto);
    public abstract String updateAnswers(UpdateAnswersListDto updateAnswersListDto);
    public abstract AnswersResponse validAnswers(ValidAnswersDto validAnswersDto);
    public abstract ExamResponse findQuestionsWithAnswers(Long id);
}
