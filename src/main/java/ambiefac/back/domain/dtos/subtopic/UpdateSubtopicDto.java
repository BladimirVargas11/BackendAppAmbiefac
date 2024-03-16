package ambiefac.back.domain.dtos.subtopic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UpdateSubtopicDto {
    @NotBlank(message = "name is required")
    private String name;
    @NotNull(message = "Se necesita el id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
