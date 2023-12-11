package ambiefac.back.domain.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "exam")
public class ExamEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date examDate;
    @ManyToOne(targetEntity = TopicEntity.class)
    @JoinColumn(name = "topic")
    private TopicEntity topic;

    public ExamEntity(){
        this.examDate = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public TopicEntity getTopic() {
        return topic;
    }

    public void setTopic(TopicEntity topic) {
        this.topic = topic;
    }
}
