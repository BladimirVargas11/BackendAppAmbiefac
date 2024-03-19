package ambiefac.back.infrastructure.datasources;

import ambiefac.back.data.response.ClientTopicInfoValidate;
import ambiefac.back.data.response.TopicInfoData;
import ambiefac.back.domain.datasources.ClientTopicInfoValidateDatasource;
import org.springframework.stereotype.Service;

@Service
public class ClientTopicInfoValidateDatasourceImp extends ClientTopicInfoValidateDatasource {

    private final ClientTopicInfoValidate clientTopicInfoValidate;

    public ClientTopicInfoValidateDatasourceImp(ClientTopicInfoValidate clientTopicInfoValidate) {
        this.clientTopicInfoValidate = clientTopicInfoValidate;
    }

    @Override
    public TopicInfoData validate(Long id, Long id_course) {
        try {
            return clientTopicInfoValidate.getValidate(id, id_course);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
