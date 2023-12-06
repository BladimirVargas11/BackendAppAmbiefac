package ambiefac.back.infrastructure.repositories;

import ambiefac.back.domain.datasources.InformationDatasource;
import ambiefac.back.domain.entities.InformationEntity;
import ambiefac.back.domain.repositories.InformationRepository;

public class InformationRepositoryImp extends InformationRepository {

    private final InformationDatasource informationDatasource;

    public InformationRepositoryImp(InformationDatasource informationDatasource) {
        this.informationDatasource = informationDatasource;
    }

    @Override
    public InformationEntity save(InformationEntity information) {
        return informationDatasource.save(information);
    }
}
