package ambiefac.back.domain.dtos.auth;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegisterTopicDto {
    @NotNull()
    @Column(unique = true)
    private String name;
    @NotNull()
    private String time;


}
