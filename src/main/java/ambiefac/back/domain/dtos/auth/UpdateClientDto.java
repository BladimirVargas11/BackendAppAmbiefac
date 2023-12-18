package ambiefac.back.domain.dtos.auth;

import lombok.Data;

@Data
public class UpdateClientDto {

    private String fullName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
