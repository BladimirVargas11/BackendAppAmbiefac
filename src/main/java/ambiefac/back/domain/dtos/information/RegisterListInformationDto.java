package ambiefac.back.domain.dtos.information;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class RegisterListInformationDto {
    @NotNull
    private Long idSubtopic;
    @Valid
    private List<InformationListDto> listInformation;

    public List<InformationListDto> getListInformation() {
        return listInformation;
    }

    public void setListInformation(List<InformationListDto> listInformation) {
        this.listInformation = listInformation;
    }

    public Long getIdSubtopic() {
        return idSubtopic;
    }

    public void setIdSubtopic(Long idSubtopic) {
        this.idSubtopic = idSubtopic;
    }
}
