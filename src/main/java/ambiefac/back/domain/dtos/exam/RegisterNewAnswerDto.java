package ambiefac.back.domain.dtos.exam;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterNewAnswerDto {
    @NotBlank(message = "El id no puede estar vacio")
    private Long questionID;

    @NotBlank(message = "El texto de la pregunta no puede estar vacio")
    private String answerText;

    @NotBlank(message = "El es correcto no puede estar vacio")
    private Boolean isCorrect;

    public Long getQuestionID() {
        return questionID;
    }

    public void setQuestionID(Long questionID) {
        this.questionID = questionID;
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
}
