package ambiefac.back.infrastructure.repositories;

import ambiefac.back.domain.datasources.SubtopicDatasource;
import ambiefac.back.domain.entities.SubtopicEntity;
import ambiefac.back.domain.repositories.SubtopicRepository;

public class SubtopicRepositoryImp extends SubtopicRepository {

    private final SubtopicDatasource subtopicDatasource;

    public SubtopicRepositoryImp(SubtopicDatasource subtopicDatasource) {
        this.subtopicDatasource = subtopicDatasource;
    }

    @Override
    public SubtopicEntity save(SubtopicEntity subtopic) {
        return subtopicDatasource.save(subtopic);
    }
}
