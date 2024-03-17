package ambiefac.back.infrastructure.datasources;

import ambiefac.back.data.Information;
import ambiefac.back.data.Subtopic;
import ambiefac.back.domain.dtos.information.*;
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
            Optional<SubtopicEntity> subtopicEntity = subtopicRepository.findById(information.getIdSubtopic());
            if(subtopicEntity.isPresent()){
                for (InformationListDto informationListDto : information.getListInformation()) {
                    InformationEntity informationEntity = convertDto(informationListDto);
                    informationEntity.setSubtopic(subtopicEntity.get());
                    informationRepository.save(informationEntity);
                }
            }else{
                throw new EntityNotFoundException("No existe un subtopic con este id");
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

    @Override
    public List<InformationEntity> findInformationOfSubtopic(Long id) {
        try {
            return informationRepository.findBySubtopicId(id);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public String deleteInformation(Long id) {
        Optional<InformationEntity> informationEntity = informationRepository.findById(id);
        if(informationEntity.isPresent()){
            informationRepository.delete(informationEntity.get());
            return "Se elimino con exito";
        }else{
            throw  new EntityNotFoundException("No hay un registro con este id");
        }
    }

    private InformationEntity convertDto(InformationListDto informationListDto){

            InformationEntity informationEntity = new InformationEntity();
            informationEntity.setTitle(informationListDto.getTitle());
            informationEntity.setContent(informationListDto.getContent());
            informationEntity.setType(informationListDto.getType());
            informationEntity.setPosition(informationListDto.getPosition());
            return informationEntity;
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


