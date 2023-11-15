package ambiefac.back.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class Topic{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Topic(){}

    public List<TopicResponse> findTopic(){

        String sql = "SELECT\n" +
                "  topic.id,\n" +
                "  topic.name,\n" +
                "  subtopic.id,\n" +
                "  subtopic.name AS 'subtopic_name',\n" +
                "  information.id,\n" +
                "  information.content\n" +
                "FROM\n" +
                "  topic\n" +
                "  LEFT JOIN subtopic ON topic.id = subtopic.topic\n" +
                "  LEFT JOIN information ON subtopic.id = information.subtopic";

        Map<Long, TopicResponse> topicMap = new HashMap<>();
         jdbcTemplate.query(sql, new RowMapper<TopicResponse>() {
            @Override
            public TopicResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

                Long topicId = rs.getLong("id");
                if(!topicMap.containsKey(topicId)){
                    TopicResponse topicResponse = new TopicResponse();
                    topicResponse.setId(topicId);
                    topicResponse.setName(rs.getString("name"));
                    topicResponse.setSubtopic(new ArrayList<>());
                    topicMap.put(topicId,topicResponse);
                }

                SubtopicResponse subtopicResponse = new SubtopicResponse();
                subtopicResponse.setSubtopic_id(topicId);
                subtopicResponse.setSubtopic_name(rs.getString("subtopic_name"));
                subtopicResponse.setInformation(new ArrayList<>());

                InformationResponse informationResponse = new InformationResponse();
                informationResponse.setInformation_id(rs.getLong("id"));
                informationResponse.setContent(rs.getString("content"));


                topicMap.get(topicId).getSubtopic().add(subtopicResponse);
                subtopicResponse.getInformation().add(informationResponse);

            return null;

            }

        });

        return new ArrayList<>(topicMap.values());

    }


}
