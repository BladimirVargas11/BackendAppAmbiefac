package ambiefac.back.domain.repositories;

import ambiefac.back.domain.dtos.subtopic.RegisterSubtopicDto;
import ambiefac.back.domain.entities.SubtopicEntity;

public abstract class SubtopicRepository {

    public abstract SubtopicEntity save(RegisterSubtopicDto subtopic);
}
