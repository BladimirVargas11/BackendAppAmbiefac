package ambiefac.back.infrastructure.repositories;

import ambiefac.back.domain.datasources.InformationDatasource;
import ambiefac.back.domain.dtos.information.RegisterInformationDto;
import ambiefac.back.domain.dtos.information.RegisterListInformationDto;
import ambiefac.back.domain.entities.InformationEntity;
import ambiefac.back.domain.repositories.InformationRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class InformationRepositoryImp extends InformationRepository {

    private final InformationDatasource informationDatasource;

    public InformationRepositoryImp(InformationDatasource informationDatasource) {
        this.informationDatasource = informationDatasource;
    }

    @Override
    public String save(RegisterListInformationDto information) {
        return informationDatasource.save(information);
    }
}
