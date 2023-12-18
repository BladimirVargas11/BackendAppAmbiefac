package ambiefac.back.domain.dtos.information;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateInformationDto {
    @NotNull(message = "Se necesita el id de la informacion")
    private Long id;
    @NotBlank(message = "El contenido no puede estar vacio")
    private String content;
    @NotBlank(message = "El titulo no puede estar vacio")
    private String title;
    @NotBlank(message = "El typo no puede estar vacio")
    private String type;
    @NotNull
    private Long position;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getPosition() {
        return position;
    }

    public void setPosition(Long position) {
        this.position = position;
    }
}
