package ambiefac.back.domain.datasources;

import ambiefac.back.domain.dtos.subtopic.RegisterSubtopicDto;
import ambiefac.back.domain.entities.SubtopicEntity;

import java.util.List;

public abstract class SubtopicDatasource {

    public abstract SubtopicEntity save(RegisterSubtopicDto subtopic);

    public abstract List<SubtopicEntity> findTopicsOfTopic(Long id);
}
