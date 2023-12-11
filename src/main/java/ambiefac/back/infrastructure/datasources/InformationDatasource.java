package ambiefac.back.infrastructure.datasources;

import ambiefac.back.data.Information;
import ambiefac.back.data.Subtopic;
import ambiefac.back.domain.dtos.information.RegisterInformationDto;
import ambiefac.back.domain.dtos.information.RegisterListInformationDto;
import ambiefac.back.domain.entities.InformationEntity;
import ambiefac.back.domain.entities.SubtopicEntity;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class InformationDatasource extends ambiefac.back.domain.datasources.InformationDatasource {

    private final Information informationRepository;
    private final Subtopic subtopicRepository;

    public InformationDatasource(Information informationRepository, Subtopic subtopicRepository) {
        this.informationRepository = informationRepository;
        this.subtopicRepository = subtopicRepository;
    }

    @Override
    @Transactional
    public String save(RegisterListInformationDto information) {


        try {
            for (RegisterInformationDto registerInformationDto : information.getListInformation()) {
                InformationEntity informationEntity = convertDto(registerInformationDto);
                informationRepository.save(informationEntity);
            }
            return "Se registro con exito";
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }


    }

    private InformationEntity convertDto(RegisterInformationDto registerInformationDto){
        Optional<SubtopicEntity> subtopicEntity = subtopicRepository.findById(registerInformationDto.getIdSubtopic());
        if(subtopicEntity.isPresent()){
            InformationEntity informationEntity = new InformationEntity();
            informationEntity.setTitle(registerInformationDto.getTitle());
            informationEntity.setContent(registerInformationDto.getContent());
            informationEntity.setType(registerInformationDto.getType());
            informationEntity.setPosition(registerInformationDto.getPosition());
            informationEntity.setSubtopic(subtopicEntity.get());
            return informationEntity;
        }{
            throw new EntityNotFoundException("There is no subtopic with this id");
        }
    }
}


