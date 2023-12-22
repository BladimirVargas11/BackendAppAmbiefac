package ambiefac.back.domain.dtos.exam;

import jakarta.validation.Valid;
import lombok.Data;

import java.util.List;

@Data
public class UpdateAnswersListDto {
    @Valid
    private List<UpdateAnswerDto> answers;

    public List<UpdateAnswerDto> getAnswers() {
        return answers;
    }

    public void setAnswers(List<UpdateAnswerDto> answers) {
        this.answers = answers;
    }
}
