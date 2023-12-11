package ambiefac.back.domain.dtos.exam;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RegisterQuestionDto {
    @NotNull
    @NotBlank(message = "El texto de la pregunta no puede estar vacio")
    private String questionStatement;
    @Valid
    @NotNull(message = "La lista de respuestas no puede estar vacia")
    private List<RegisterAnswerDto> answers;


    public String getQuestionStatement() {
        return questionStatement;
    }

    public void setQuestionStatement(String questionStatement) {
        this.questionStatement = questionStatement;
    }

    public List<RegisterAnswerDto> getAnswers() {
        return answers;
    }

    public void setAnswers(List<RegisterAnswerDto> answers) {
        this.answers = answers;
    }
}
