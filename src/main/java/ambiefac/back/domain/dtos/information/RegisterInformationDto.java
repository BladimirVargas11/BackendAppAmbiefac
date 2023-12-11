package ambiefac.back.domain.dtos.information;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegisterInformationDto {

    @NotBlank
    private String content;
    private String title;
    @NotBlank
    private String type;
    @NotNull
    private Long position;
    @NotNull
    @NotBlank
    private Long idSubtopic;

    public RegisterInformationDto(){}

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

    public Long getIdSubtopic() {
        return idSubtopic;
    }

    public void setIdSubtopic(Long idSubtopic) {
        this.idSubtopic = idSubtopic;
    }
}
