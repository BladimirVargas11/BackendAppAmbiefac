package ambiefac.back.domain.dtos.exam;

import jakarta.validation.Valid;
import lombok.Data;

import java.util.List;

@Data
public class ValidAnswersDto {
    @Valid
    private List<AnswersIdsDto> answersIds;
    private Long idClient;
    private Long idTopic;

    public Long getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(Long idTopic) {
        this.idTopic = idTopic;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public List<AnswersIdsDto> getAnswersIds() {
        return answersIds;
    }

    public void setAnswersIds(List<AnswersIdsDto> answersIds) {
        this.answersIds = answersIds;
    }
}
