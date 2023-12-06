package ambiefac.back.domain.datasources;

import ambiefac.back.domain.entities.InformationEntity;

public abstract class InformationDatasource {

    public abstract InformationEntity save(InformationEntity information);
}
