package ambiefac.back.domain.dtos.information;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class RegisterListInformationDto {

    @Valid
    private List<RegisterInformationDto> listInformation;

    public List<RegisterInformationDto> getListInformation() {
        return listInformation;
    }

    public void setListInformation(List<RegisterInformationDto> listInformation) {
        this.listInformation = listInformation;
    }


}
