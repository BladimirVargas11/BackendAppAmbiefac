package ambiefac.back.domain.entities;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "client_topic", uniqueConstraints = @UniqueConstraint(columnNames = {"client","topic"}))
public class ClientTopicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registrationId;
    private Date registrationDate;
    private Boolean isCompleted;
    private int score;
    @ManyToOne(targetEntity = ClientEntity.class)
    @JoinColumn(name = "client")
    private ClientEntity client;
    @ManyToOne(targetEntity = TopicEntity.class)
    @JoinColumn(name = "topic")
    private TopicEntity topic;

    public ClientTopicEntity(){
        this.registrationDate = new Date();
        this.isCompleted = false;
        this.score = 0;
    }

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

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public TopicEntity getTopic() {
        return topic;
    }

    public void setTopic(TopicEntity topic) {
        this.topic = topic;
    }
}
