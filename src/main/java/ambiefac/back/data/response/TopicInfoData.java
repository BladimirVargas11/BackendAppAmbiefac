package ambiefac.back.data.response;

import java.sql.Date;

public class TopicInfoData {
    public Long getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Long registrationId) {
        this.registrationId = registrationId;
    }

    public TopicInfoTopic getTopic() {
        return topic;
    }

    public void setTopic(TopicInfoTopic topic) {
        this.topic = topic;
    }


    private Long registrationId;

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    private Date registrationDate;

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    private Long score;
    private TopicInfoTopic topic;

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    private Boolean completed;
}
