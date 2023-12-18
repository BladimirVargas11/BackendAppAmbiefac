package ambiefac.back.domain.repositories;

import ambiefac.back.domain.dtos.information.RegisterInformationDto;
import ambiefac.back.domain.dtos.information.RegisterListInformationDto;
import ambiefac.back.domain.dtos.information.UpdateListInformationDto;
import ambiefac.back.domain.entities.InformationEntity;

import java.util.List;

public abstract class InformationRepository {

    public abstract String save(RegisterListInformationDto information);

    public abstract String updateInformation(UpdateListInformationDto updateListInformationDto);
}
