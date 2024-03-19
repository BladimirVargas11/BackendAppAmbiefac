package ambiefac.back.data;

import ambiefac.back.domain.entities.ClientTopicEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientTopic extends CrudRepository<ClientTopicEntity,Long> {

    boolean existsByClientIdAndTopicId(Long client, Long topic);
    Optional<ClientTopicEntity> findByClientIdAndTopicId(Long clientId, Long topicId);
}
