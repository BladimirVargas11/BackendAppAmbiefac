package ambiefac.back.domain.datasources;

import ambiefac.back.domain.dtos.subtopic.RegisterSubtopicDto;
import ambiefac.back.domain.entities.SubtopicEntity;

public abstract class SubtopicDatasource {

    public abstract SubtopicEntity save(RegisterSubtopicDto subtopic);
}
