package ambiefac.back.infrastructure.datasources;

import ambiefac.back.data.*;
import ambiefac.back.data.response.AnswerResponse;
import ambiefac.back.data.response.AnswersResponse;
import ambiefac.back.data.response.ExamResponse;
import ambiefac.back.domain.dtos.exam.*;
import ambiefac.back.domain.entities.ExamEntity;
import ambiefac.back.domain.entities.ExamQuestionEntity;
import ambiefac.back.domain.entities.QuestionAnswerEntity;
import ambiefac.back.domain.entities.TopicEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ExamDatasource extends ambiefac.back.domain.datasources.ExamDatasource {

    private final Exam examRepository;
    private final QuestionExam questionExamRepository;
    private final QuestionAnswer questionAnswerRepository;
    private final TopicSave topicSave;
    private final ExamQuery examQuery;

    public ExamDatasource(Exam examRepository, QuestionExam questionExamRepository, QuestionAnswer questionAnswerRepository, TopicSave topicSave, ExamQuery examQuery) {
        this.examRepository = examRepository;
        this.questionExamRepository = questionExamRepository;
        this.questionAnswerRepository = questionAnswerRepository;
        this.topicSave = topicSave;
        this.examQuery = examQuery;
    }

    @Override
    public String save(RegisterExamDto examDto) {
        Optional<TopicEntity> topic = topicSave.findById(examDto.getIdTopic());
        if(topic.isPresent()){
            ExamEntity exam = new ExamEntity();
            exam.setTopic(topic.get());
            examRepository.save(exam);

            for(RegisterQuestionDto registerQuestionDto: examDto.getQuestions()){
                ExamQuestionEntity examQuestionEntity = new ExamQuestionEntity();
                examQuestionEntity.setQuestionStatement(registerQuestionDto.getQuestionStatement());
                examQuestionEntity.setExam(exam);
                questionExamRepository.save(examQuestionEntity);
                for (RegisterAnswerDto registerAnswerDto: registerQuestionDto.getAnswers()){
                    QuestionAnswerEntity answerEntity = new QuestionAnswerEntity();
                    answerEntity.setAnswerText(registerAnswerDto.getAnswerText());
                    answerEntity.setCorrect(registerAnswerDto.getCorrect());
                    answerEntity.setQuestion(examQuestionEntity);
                    questionAnswerRepository.save(answerEntity);
                }
            }
            return "Se registro exitosamente";

        }else {
            throw new EntityNotFoundException("There is no topic with this id");
        }
    }

    @Override
    public String updateQuestions(UpdateQuestionsListDto updateQuestionsListDto) {
        for(UpdateQuestionDto updateQuestionDto: updateQuestionsListDto.getQuestions()){
            Optional<ExamQuestionEntity> question = questionExamRepository.findById(updateQuestionDto.getId());
            if(question.isPresent()){
                question.get().setQuestionStatement(updateQuestionDto.getQuestionStatement());
                questionExamRepository.save(question.get());
            }else{
                throw new EntityNotFoundException("No existe una pregunta con este id");
            }

        }
        return "Se actualizo con exito";
    }

    @Override
    public String updateAnswers(UpdateAnswersListDto updateAnswersListDto) {
        for(UpdateAnswerDto updateAnswerDto: updateAnswersListDto.getAnswers()){
            Optional<QuestionAnswerEntity> answer = questionAnswerRepository.findById(updateAnswerDto.getId());
            if(answer.isPresent()){
                answer.get().setAnswerText(updateAnswerDto.getAnswerText());
                answer.get().setCorrect(updateAnswerDto.getCorrect());
                questionAnswerRepository.save(answer.get());
            }else{
                throw new EntityNotFoundException("No existe un examen con este id");
            }

        }
        return "Se actualizo con exito";
    }

    @Override
    public AnswersResponse validAnswers(ValidAnswersDto validAnswersDto) {
        List<AnswerResponse> listAnswers = new ArrayList<>();
        for(AnswersIdsDto answersIdsDto: validAnswersDto.getAnswersIds()){
            Optional<QuestionAnswerEntity> answer = questionAnswerRepository.findById(answersIdsDto.getId());
            if(answer.isPresent()){
              AnswerResponse answerResponse = new AnswerResponse();
              answerResponse.setId(answer.get().getId());
              answerResponse.setCorrect(answer.get().getCorrect());
              listAnswers.add(answerResponse);
            }else{
                throw new EntityNotFoundException("No existe una respuesta con este id");
            }
        }
        AnswersResponse answersResponse = new AnswersResponse();
        answersResponse.setAnswers(listAnswers);
        answersResponse.setScore(calculateScore(listAnswers));
        return answersResponse;

    }

    @Override
    public ExamResponse findQuestionsWithAnswers(Long id) {
        try{
            return examQuery.findExamWithQuestions(id);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public double calculateScore(List<AnswerResponse> listAnswers){
        int answersCorrect = 0;
        for(AnswerResponse answersIdsDto:listAnswers){
            if(answersIdsDto.getCorrect()){
                answersCorrect++;
            }
        }
        double total = ((double) answersCorrect/listAnswers.size()) *100;

        return total * 100;
    }
}
