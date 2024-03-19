package ambiefac.back.data.response;

import java.util.Date;

public class ClientTopicListResponse {

    private Long registrationId;
    private Date registrationDate;
    private Double score;
    private  TopicListResponse topic;
    private  boolean completed;

    public Long getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Long registrationId) {
        this.registrationId = registrationId;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public TopicListResponse getTopic() {
        return topic;
    }

    public void setTopic(TopicListResponse topic) {
        this.topic = topic;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
