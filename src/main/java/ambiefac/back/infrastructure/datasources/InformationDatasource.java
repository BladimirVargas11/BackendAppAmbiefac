package ambiefac.back.infrastructure.datasources;

import ambiefac.back.data.Information;
import ambiefac.back.data.Subtopic;
import ambiefac.back.domain.dtos.information.RegisterInformationDto;
import ambiefac.back.domain.dtos.information.RegisterListInformationDto;
import ambiefac.back.domain.dtos.information.UpdateInformationDto;
import ambiefac.back.domain.dtos.information.UpdateListInformationDto;
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

    @Override
    public String updateInformation(UpdateListInformationDto updateListInformationDto) {
        try{
            for(UpdateInformationDto updateInformationDto:updateListInformationDto.getListInformation()){
                InformationEntity informationEntity = convertDtoUpdate(updateInformationDto);
                informationRepository.save(informationEntity);
            }
            return "Se actualizo la informacion con exito";
        }catch (Exception e){
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

    private InformationEntity convertDtoUpdate(UpdateInformationDto updateInformationDto){
        Optional<InformationEntity> informationEntity = informationRepository.findById(updateInformationDto.getId());
        if(informationEntity.isPresent()){
            informationEntity.get().setTitle(updateInformationDto.getTitle());
            informationEntity.get().setContent(updateInformationDto.getContent());
            informationEntity.get().setType(updateInformationDto.getType());
            informationEntity.get().setPosition(updateInformationDto.getPosition());
            return informationEntity.get();
        }{
            throw new EntityNotFoundException("No existe informacion con este id");
        }
    }
}


