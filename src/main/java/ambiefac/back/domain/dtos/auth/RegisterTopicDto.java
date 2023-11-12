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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
