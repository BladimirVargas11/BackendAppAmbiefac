package ambiefac.back.data;

import ambiefac.back.data.response.InformationResponse;
import ambiefac.back.data.response.SubtopicResponse;
import ambiefac.back.data.response.TopicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

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
                "  LEFT JOIN information ON subtopic.id = information.subtopic WHERE topic.deleted = false";

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

    public TopicResponse obtenerInformacionPorCurso(Long cursoId) {
        String sql = "SELECT topic.id, topic.name, " +
                "subtopic.id AS subtopic_id, subtopic.name AS subtopic_name, information.id AS information_id," +
                " information.content, information.has_video, information.link_video " +
                "FROM topic " +
                "LEFT JOIN subtopic ON topic.id = subtopic.topic " +
                "LEFT JOIN information ON subtopic.id = information.subtopic " +
                "WHERE topic.id = ? " +
                "ORDER BY topic.name ";

        Map<Long, TopicResponse> topicMap = new HashMap<>();

        List<TopicResponse> result = jdbcTemplate.query(sql, new Object[]{cursoId}, (rs, rowNum) -> {
            Long topicId = rs.getLong("id");

            if (!topicMap.containsKey(topicId)) {
                TopicResponse topicDTO = new TopicResponse();
                topicDTO.setId(topicId);
                topicDTO.setName(rs.getString("name"));
                topicDTO.setSubtopic(new ArrayList<>());
                topicMap.put(topicId, topicDTO);
            }

            SubtopicResponse subtopicDTO = new SubtopicResponse();
            subtopicDTO.setSubtopic_id(rs.getLong("subtopic_id"));
            subtopicDTO.setSubtopic_name(rs.getString("subtopic_name"));

            InformationResponse informationDTO = new InformationResponse();
            informationDTO.setInformation_id(rs.getLong("information_id"));
            informationDTO.setContent(rs.getString("content"));
            informationDTO.setHas_video(rs.getString("has_video"));
            informationDTO.setLink_video(rs.getString("link_video"));

            topicMap.get(topicId).getSubtopic().add(subtopicDTO);
            subtopicDTO.setInformation(Collections.singletonList(informationDTO));

            return null;
        });

        List<TopicResponse> resultList = new ArrayList<>(topicMap.values());


        return resultList.isEmpty() ? null : resultList.get(0);
    }



}
