package ambiefac.back.domain.datasources;

import ambiefac.back.data.response.AnswersResponse;
import ambiefac.back.data.response.ExamResponse;
import ambiefac.back.domain.dtos.exam.*;
import ambiefac.back.domain.entities.QuestionAnswerEntity;

import java.util.List;

public abstract class ExamDatasource {

    public abstract String save(RegisterExamDto examDto);

    public abstract String updateQuestions(UpdateQuestionsListDto updateQuestionsListDto);

    public abstract String updateAnswers(UpdateAnswersListDto updateAnswersListDto);

    public abstract AnswersResponse validAnswers(ValidAnswersDto validAnswersDto);

    public abstract ExamResponse findQuestionsWithAnswers(Long id);
    public abstract String saveNewQuestions(Long id, RegisterQuestionDto registerQuestionDto);
    public abstract String saveNewAnswer(List<RegisterNewAnswerDto> newAnswer);
    public abstract String Deletequestion(Long id);
    public abstract String deleteAnswer(Long id);

}
