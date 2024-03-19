package ambiefac.back.data;

import ambiefac.back.data.response.ClientTopicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class ClientTopicList {

    private final JdbcTemplate jdbcTemplate;

    public ClientTopicList(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ClientTopicResponse> getClientCourses(Long clientId) {
        String sql = "SELECT topic.id AS topic_id, topic.name, client.full_name, client.id AS client_id, " +
                "client_topic.registration_id, client_topic.registration_date, topic.link_image, client_topic.score " +
                "FROM client_topic " +
                "LEFT JOIN topic ON topic.id = client_topic.topic " +
                "LEFT JOIN client ON client.id = client_topic.client " +
                "WHERE client.id = ?";

        return jdbcTemplate.query(sql, new Object[]{clientId}, (rs, rowNum) -> {
            ClientTopicResponse clientCourseDTO = new ClientTopicResponse();
            clientCourseDTO.setTopicId(rs.getLong("topic_id"));
            clientCourseDTO.setTopicName(rs.getString("name"));
            clientCourseDTO.setClientFullName(rs.getString("full_name"));
            clientCourseDTO.setClientId(rs.getLong("client_id"));
            clientCourseDTO.setRegistrationId(rs.getLong("registration_id"));
            clientCourseDTO.setRegistrationDate(rs.getDate("registration_date"));
            clientCourseDTO.setLinkImage(rs.getString("link_image"));
            clientCourseDTO.setScore(rs.getLong("score"));

            return clientCourseDTO;
        });
    }
}
