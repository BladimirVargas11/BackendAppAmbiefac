package ambiefac.back.domain.dtos.exam;

import jakarta.validation.Valid;
import lombok.Data;

import java.util.List;

@Data
public class ValidAnswersDto {
    @Valid
    private List<AnswersIdsDto> answersIds;

    public List<AnswersIdsDto> getAnswersIds() {
        return answersIds;
    }

    public void setAnswersIds(List<AnswersIdsDto> answersIds) {
        this.answersIds = answersIds;
    }
}
