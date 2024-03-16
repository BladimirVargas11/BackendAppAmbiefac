package ambiefac.back.domain.datasources;

import ambiefac.back.domain.dtos.subtopic.RegisterSubtopicDto;
import ambiefac.back.domain.dtos.subtopic.UpdateSubtopicDto;
import ambiefac.back.domain.entities.SubtopicEntity;

import java.util.List;

public abstract class SubtopicDatasource {

    public abstract SubtopicEntity save(RegisterSubtopicDto subtopic);

    public abstract String update(UpdateSubtopicDto subtopic);

    public abstract String delete(Long id);

    public abstract List<SubtopicEntity> findTopicsOfTopic(Long id);
}
