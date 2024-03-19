package ambiefac.back.data;

import ambiefac.back.data.response.InformationResponse;
import ambiefac.back.data.response.SubtopicResponse;
import ambiefac.back.data.response.TopicResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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
public class Topic {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Topic() {
    }


    public List<TopicResponse> findTopic() {

        String sql = "SELECT\n" +
                "  topic.id,\n" +
                "  topic.name, topic.description, topic.time, topic.link_image,\n" +
                "  subtopic.id,\n" +
                "  exam.id AS 'exam_id',"+
                "  subtopic.name AS 'subtopic_name'\n" +
                "FROM\n" +
                "  topic\n" +
                "  LEFT JOIN subtopic ON topic.id = subtopic.topic\n" +
                "  LEFT JOIN information ON subtopic.id = information.subtopic " +
                "  LEFT JOIN exam ON topic.id = exam.topic" +
                "  WHERE topic.deleted = false";

        Map<Long, TopicResponse> topicMap = new HashMap<>();
        jdbcTemplate.query(sql, new RowMapper<TopicResponse>() {
            @Override
            public TopicResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

                Long topicId = rs.getLong("id");
                if (!topicMap.containsKey(topicId)) {
                    TopicResponse topicResponse = new TopicResponse();
                    topicResponse.setId(topicId);
                    topicResponse.setName(rs.getString("name"));
                    topicResponse.setDescription(rs.getString("description"));
                    topicResponse.setTime(rs.getString("time"));
                    topicResponse.setLinkImage(rs.getString("link_image"));
                    topicResponse.setExam_id(rs.getLong("exam_id"));
                    topicResponse.setSubtopic(new ArrayList<>());
                    topicMap.put(topicId, topicResponse);
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
        String sql = "SELECT topic.id, topic.name, topic.description, topic.time, topic.link_image, " +
                "subtopic.id AS subtopic_id, subtopic.name AS subtopic_name, " +
                "information.id AS information_id, information.content, information.title, " +
                "information.type, information.position, exam.id AS exam_id " +
                "FROM topic LEFT JOIN subtopic ON topic.id = subtopic.topic " +
                "LEFT JOIN exam ON exam.topic = topic.id " +
                "LEFT JOIN information ON subtopic.id = information.subtopic " +
                "WHERE topic.id = ? " +
                "ORDER BY topic.name ";

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, cursoId);

        if (rows.isEmpty()) {
            return null;
        }

        Map<Long, TopicResponse> topicMap = new LinkedHashMap<>();

        for (Map<String, Object> row : rows) {
            Long topicId = (Long) row.get("id");

            if (!topicMap.containsKey(topicId)) {
                TopicResponse topicDTO = new TopicResponse();
                topicDTO.setId(topicId);
                topicDTO.setName((String) row.get("name"));
                topicDTO.setDescription((String) row.get("description"));
                topicDTO.setTime((String) row.get("time"));
                topicDTO.setLinkImage((String) row.get("link_image"));
                topicDTO.setExam_id((Long) row.get("exam_id"));
                topicDTO.setSubtopic(new ArrayList<>());
                topicMap.put(topicId, topicDTO);
            }

            SubtopicResponse subtopicDTO = new SubtopicResponse();
            subtopicDTO.setSubtopic_id((Long) row.get("subtopic_id"));
            subtopicDTO.setSubtopic_name((String) row.get("subtopic_name"));

            InformationResponse informationDTO = new InformationResponse();
            informationDTO.setInformation_id((Long) row.get("information_id"));
            informationDTO.setContent((String) row.get("content"));
            informationDTO.setTitle((String) row.get("title"));
            informationDTO.setType((String) row.get("type"));
            informationDTO.setPosition((Long) row.get("position"));

            TopicResponse topic = topicMap.get(topicId);
            List<SubtopicResponse> subtopics = topic.getSubtopic();

            SubtopicResponse existingSubtopic = subtopics.stream()
                    .filter(subtopic -> subtopic.getSubtopic_id().equals(subtopicDTO.getSubtopic_id()))
                    .findFirst()
                    .orElse(null);

            if (existingSubtopic == null) {
                subtopicDTO.setInformation(new ArrayList<>());
                subtopics.add(subtopicDTO);
                existingSubtopic = subtopicDTO;
            }

            existingSubtopic.getInformation().add(informationDTO);
        }

        return topicMap.values().iterator().next();
    }


    public List<TopicResponse> findTopicByKeyword(String jsonKeyword) {

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode keywordNode;
        String keyword = "";

        try {
            keywordNode = objectMapper.readTree(jsonKeyword);
            keyword = keywordNode.get("world").asText();
        } catch (Exception e) {
            // Manejar excepción en la conversión del JSON o acceso a la propiedad "world"
            e.printStackTrace();
        }
        String sql = "SELECT topic.id, topic.name, topic.time, topic.link_image " +
                "FROM topic " +
                "LEFT JOIN subtopic ON topic.id = subtopic.topic " +
                "LEFT JOIN information ON subtopic.id = information.subtopic " +
                "WHERE topic.deleted = false " +
                "AND topic.name LIKE '%" + keyword + "%' OR subtopic.name LIKE '%" + keyword + "%'";

        System.out.println(sql);
        System.out.println(keyword);

        List<TopicResponse> topics = jdbcTemplate.query(sql, new RowMapper<TopicResponse>() {
            @Override
            public TopicResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
                TopicResponse topicResponse = new TopicResponse();
                topicResponse.setId(rs.getLong("id"));
                topicResponse.setName(rs.getString("name"));
                topicResponse.setTime(rs.getString("time"));
                topicResponse.setLinkImage(rs.getString("link_image"));
                return topicResponse;
            }
        });

        return topics;
    }


}
