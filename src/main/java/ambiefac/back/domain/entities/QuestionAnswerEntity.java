package ambiefac.back.domain.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "question_answer")
public class QuestionAnswerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String answerText;
    private Boolean isCorrect;
    @ManyToOne(targetEntity = ExamQuestionEntity.class)
    @JoinColumn(name = "question")
    private ExamQuestionEntity question;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public Boolean getCorrect() {
        return isCorrect;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }

    public ExamQuestionEntity getQuestion() {
        return question;
    }

    public void setQuestion(ExamQuestionEntity question) {
        this.question = question;
    }
}
