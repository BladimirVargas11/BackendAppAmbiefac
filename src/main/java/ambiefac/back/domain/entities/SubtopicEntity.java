package ambiefac.back.domain.entities;

import jakarta.persistence.*;

@Entity
public class SubtopicEntity {

    @Id
    private Long id;

    private String name;
    @ManyToOne(targetEntity = TopicEntity.class)
    @JoinColumn(name = "topic")
    private TopicEntity topic;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TopicEntity getTopic() {
        return topic;
    }

    public void setTopic(TopicEntity topic) {
        this.topic = topic;
    }
}
