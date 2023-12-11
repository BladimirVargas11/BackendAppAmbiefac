package ambiefac.back.domain.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "information")
public class InformationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private String title;
    private String type;
    private Long position;

    @OneToOne(targetEntity = SubtopicEntity.class )
    @JoinColumn(name = "subtopic")
    private SubtopicEntity subtopic;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public SubtopicEntity getSubtopic() {
        return subtopic;
    }

    public void setSubtopic(SubtopicEntity subtopic) {
        this.subtopic = subtopic;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getPosition() {
        return position;
    }

    public void setPosition(Long position) {
        this.position = position;
    }
}
