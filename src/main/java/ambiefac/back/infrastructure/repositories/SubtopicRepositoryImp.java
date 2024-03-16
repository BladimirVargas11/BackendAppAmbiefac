package ambiefac.back.infrastructure.repositories;

import ambiefac.back.domain.datasources.SubtopicDatasource;
import ambiefac.back.domain.dtos.subtopic.RegisterSubtopicDto;
import ambiefac.back.domain.dtos.subtopic.UpdateSubtopicDto;
import ambiefac.back.domain.entities.SubtopicEntity;
import ambiefac.back.domain.repositories.SubtopicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubtopicRepositoryImp extends SubtopicRepository {

    private final SubtopicDatasource subtopicDatasource;

    public SubtopicRepositoryImp(SubtopicDatasource subtopicDatasource) {
        this.subtopicDatasource = subtopicDatasource;
    }

    @Override
    public SubtopicEntity save(RegisterSubtopicDto subtopic) {
        return subtopicDatasource.save(subtopic);
    }

    @Override
    public String update(UpdateSubtopicDto subtopic) {
        return subtopicDatasource.update(subtopic);
    }

    @Override
    public String delete(Long id) {
        return subtopicDatasource.delete(id);
    }

    @Override
    public List<SubtopicEntity> findTopicsOfTopic(Long id) {
        return subtopicDatasource.findTopicsOfTopic(id);
    }
}
