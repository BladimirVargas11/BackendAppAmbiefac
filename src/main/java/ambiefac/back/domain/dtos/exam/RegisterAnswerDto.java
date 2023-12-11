package ambiefac.back.domain.dtos.exam;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegisterAnswerDto {

    @NotBlank(message = "El texto de la respuesta no puede estar vacio")
    private String answerText;
    @NotNull
    private Boolean isCorrect;

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
