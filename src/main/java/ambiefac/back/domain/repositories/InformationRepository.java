package ambiefac.back.domain.repositories;

import ambiefac.back.domain.entities.InformationEntity;

public abstract class InformationRepository {

    public abstract InformationEntity save(InformationEntity information);
}
