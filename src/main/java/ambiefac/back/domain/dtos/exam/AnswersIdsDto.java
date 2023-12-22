package ambiefac.back.domain.dtos.exam;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AnswersIdsDto {
    @NotNull
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
