package ambiefac.back.domain.dtos.exam;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RegisterExamDto {

    @NotNull
    private Long idTopic;
    @Valid
    private List<RegisterQuestionDto> questions;

    public Long getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(Long idTopic) {
        this.idTopic = idTopic;
    }

    public List<RegisterQuestionDto> getQuestions() {
        return questions;
    }

    public void setQuestions(List<RegisterQuestionDto> questions) {
        this.questions = questions;
    }
}
