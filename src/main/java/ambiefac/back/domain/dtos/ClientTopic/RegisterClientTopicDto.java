package ambiefac.back.domain.dtos.ClientTopic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegisterClientTopicDto {
    @NotNull(message = "El id del cliente no puede estar vacio")
    private Long idClient;
    @NotNull(message = "El id del topic no puede estar vacio")
    private Long idTopic;

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public Long getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(Long idTopic) {
        this.idTopic = idTopic;
    }
}
