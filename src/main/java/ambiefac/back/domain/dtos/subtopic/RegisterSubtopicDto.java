package ambiefac.back.domain.dtos.subtopic;

import ambiefac.back.domain.entities.TopicEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RegisterSubtopicDto {

    @NotBlank(message = "name is required")
    private String name;

    @NotNull(message = "idTopic is required")
    private Long idTopic;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(Long idTopic) {
        this.idTopic = idTopic;
    }
}
