package ambiefac.back.domain.repositories;

import ambiefac.back.domain.dtos.subtopic.RegisterSubtopicDto;
import ambiefac.back.domain.dtos.subtopic.UpdateSubtopicDto;
import ambiefac.back.domain.entities.SubtopicEntity;

import java.util.List;

public abstract class SubtopicRepository {

    public abstract SubtopicEntity save(RegisterSubtopicDto subtopic);

    public abstract String update(UpdateSubtopicDto subtopic);
    public abstract String delete(Long id);
    public abstract List<SubtopicEntity> findTopicsOfTopic(Long id);
}
