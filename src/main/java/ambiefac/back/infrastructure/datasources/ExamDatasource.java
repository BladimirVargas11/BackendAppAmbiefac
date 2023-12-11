package ambiefac.back.infrastructure.datasources;

import ambiefac.back.data.Exam;
import ambiefac.back.data.QuestionAnswer;
import ambiefac.back.data.QuestionExam;
import ambiefac.back.data.TopicSave;
import ambiefac.back.domain.dtos.exam.RegisterAnswerDto;
import ambiefac.back.domain.dtos.exam.RegisterExamDto;
import ambiefac.back.domain.dtos.exam.RegisterQuestionDto;
import ambiefac.back.domain.entities.ExamEntity;
import ambiefac.back.domain.entities.ExamQuestionEntity;
import ambiefac.back.domain.entities.QuestionAnswerEntity;
import ambiefac.back.domain.entities.TopicEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ExamDatasource extends ambiefac.back.domain.datasources.ExamDatasource {

    private final Exam examRepository;
    private final QuestionExam questionExamRepository;
    private final QuestionAnswer questionAnswerRepository;
    private final TopicSave topicSave;

    public ExamDatasource(Exam examRepository, QuestionExam questionExamRepository, QuestionAnswer questionAnswerRepository, TopicSave topicSave) {
        this.examRepository = examRepository;
        this.questionExamRepository = questionExamRepository;
        this.questionAnswerRepository = questionAnswerRepository;
        this.topicSave = topicSave;
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
}
