package ambiefac.back.domain.dtos.information;

import jakarta.validation.Valid;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Setter
@Getter
public class UpdateListInformationDto {

    @Valid
    private List<UpdateInformationDto> listInformation;

    public List<UpdateInformationDto> getListInformation() {
        return listInformation;
    }

    public void setListInformation(List<UpdateInformationDto> listInformation) {
        this.listInformation = listInformation;
    }
}
