package ambiefac.back.data.response;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class ClientTopicInfoValidate {
    private final JdbcTemplate jdbcTemplate;

    public ClientTopicInfoValidate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public TopicInfoData getValidate(Long clientId, Long topicId) {
        String sql = "SELECT " +
                "    ct.is_completed, " +
                "    ct.score, " +
                "    ct.client, " +
                "    ct.registration_date, " +
                "    ct.registration_id, " +
                "    t.id AS topic_id, " +
                "    t.name AS topic_name, " +
                "    t.time AS topic_time, " +
                "    t.description AS topic_description, " +
                "    t.link_image AS topic_link_image, " +
                "    t.deleted AS topic_deleted " +
                "FROM " +
                "    client_topic ct " +
                "JOIN " +
                "    topic t ON ct.topic = t.id " +
                "WHERE " +
                "    ct.client = ? AND t.id = ?";

        return jdbcTemplate.queryForObject(sql, new Object[]{clientId, topicId}, (rs, rowNum) -> {
            TopicInfoData topicInfoData = new TopicInfoData();
            topicInfoData.setRegistrationId(rs.getLong("registration_id"));
            topicInfoData.setRegistrationDate(rs.getDate("registration_date"));
            topicInfoData.setScore(rs.getLong("score"));
            topicInfoData.setCompleted(rs.getBoolean("is_completed"));

            TopicInfoTopic topicInfoTopic = new TopicInfoTopic();
            topicInfoTopic.setId(rs.getLong("topic_id"));
            topicInfoTopic.setName(rs.getString("topic_name"));
            topicInfoTopic.setTime(rs.getString("topic_time"));
            topicInfoTopic.setDescription(rs.getString("topic_description"));
            topicInfoTopic.setLinkImage(rs.getString("topic_link_image"));
            topicInfoTopic.setDeleted(rs.getBoolean("topic_deleted"));

            topicInfoData.setTopic(topicInfoTopic);

            return topicInfoData;
        });
    }

}
