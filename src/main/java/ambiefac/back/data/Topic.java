package ambiefac.back.data;

import ambiefac.back.data.response.InformationResponse;
import ambiefac.back.data.response.SubtopicResponse;
import ambiefac.back.data.response.TopicResponse;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
                "  topic.name, topic.time, topic.link_image,\n" +
                "  subtopic.id,\n" +
                "  subtopic.name AS 'subtopic_name'\n" +
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
                    topicResponse.setTime(rs.getString("time"));
                    topicResponse.setLinkImage(rs.getString("link_image"));
                    topicResponse.setSubtopic(new ArrayList<>());
                    topicMap.put(topicId,topicResponse);
                }

                SubtopicResponse subtopicResponse = new SubtopicResponse();
                subtopicResponse.setSubtopic_id(topicId);
                subtopicResponse.setSubtopic_name(rs.getString("subtopic_name"));
                subtopicResponse.setInformation(new ArrayList<>());




                topicMap.get(topicId).getSubtopic().add(subtopicResponse);


            return null;

            }

        });

        return new ArrayList<>(topicMap.values());

    }

    public TopicResponse obtenerInformacionPorCurso(@Param("cursoId") Long cursoId) {
        String sql = "SELECT topic.id, topic.name, topic.time, topic.link_image, subtopic.id AS subtopic_id, \n" +
                "subtopic.name AS subtopic_name, information.id AS information_id,\n" +
                " information.content, information.type, information.position,\n" +
                " exam.id AS exam_id\n" +
                "FROM topic LEFT JOIN subtopic ON topic.id = subtopic.topic\n" +
                "left JOIN exam ON exam.topic = topic.id\n" +
                "LEFT JOIN information ON subtopic.id = information.subtopic WHERE topic.id = ?\n" +
                "ORDER BY topic.name ";

        Map<Long, TopicResponse> topicMap = new HashMap<>();

        List<TopicResponse> result = jdbcTemplate.query(sql, new Object[]{cursoId}, (rs, rowNum) -> {
            Long topicId = rs.getLong("id");

            if (!topicMap.containsKey(topicId)) {
                TopicResponse topicDTO = new TopicResponse();
                topicDTO.setId(topicId);
                topicDTO.setName(rs.getString("name"));
                topicDTO.setTime(rs.getString("time"));
                topicDTO.setLinkImage(rs.getString("link_image"));
                topicDTO.setExam_id(rs.getLong("exam_id"));
                topicDTO.setSubtopic(new ArrayList<>());
                topicMap.put(topicId, topicDTO);
            }

            SubtopicResponse subtopicDTO = new SubtopicResponse();
            subtopicDTO.setSubtopic_id(rs.getLong("subtopic_id"));
            subtopicDTO.setSubtopic_name(rs.getString("subtopic_name"));

            InformationResponse informationDTO = new InformationResponse();
            informationDTO.setInformation_id(rs.getLong("information_id"));
            informationDTO.setContent(rs.getString("content"));
            informationDTO.setPosition(rs.getLong("position"));

            topicMap.get(topicId).getSubtopic().add(subtopicDTO);
            subtopicDTO.setInformation(Collections.singletonList(informationDTO));

            return null;
        });

        List<TopicResponse> resultList = new ArrayList<>(topicMap.values());


        return resultList.isEmpty() ? null : resultList.get(0);
    }



}
