package ambiefac.back.infrastructure.datasources;

import ambiefac.back.data.Information;
import ambiefac.back.domain.entities.InformationEntity;

public class InformationDatasource extends ambiefac.back.domain.datasources.InformationDatasource {

    private final Information informationRepository;

    public InformationDatasource(Information informationRepository) {
        this.informationRepository = informationRepository;
    }

    @Override
    public InformationEntity save(InformationEntity information) {

        try{
            return informationRepository.save(information);
        }catch (RuntimeException e){
            throw new Error(e.getMessage());
        }
    }
}
