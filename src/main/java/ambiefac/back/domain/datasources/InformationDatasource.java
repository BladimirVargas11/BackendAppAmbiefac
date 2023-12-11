package ambiefac.back.domain.datasources;

import ambiefac.back.domain.dtos.information.RegisterInformationDto;
import ambiefac.back.domain.dtos.information.RegisterListInformationDto;
import ambiefac.back.domain.entities.InformationEntity;

import java.util.List;

public abstract class InformationDatasource {

    public abstract String  save(RegisterListInformationDto information);
}
