package ambiefac.back.domain.datasources;

import ambiefac.back.data.response.TopicInfoData;

public abstract class ClientTopicInfoValidateDatasource {

    public abstract TopicInfoData validate(Long id, Long id_course);
}
