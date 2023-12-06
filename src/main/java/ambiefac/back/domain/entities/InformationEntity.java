package ambiefac.back.domain.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "information")
public class InformationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private String hasVideo;
    private String linkVideo;

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

    public String getHasVideo() {
        return hasVideo;
    }

    public void setHasVideo(String hasVideo) {
        this.hasVideo = hasVideo;
    }

    public String getLinkVideo() {
        return linkVideo;
    }

    public void setLinkVideo(String linkVideo) {
        this.linkVideo = linkVideo;
    }

    public SubtopicEntity getSubtopic() {
        return subtopic;
    }

    public void setSubtopic(SubtopicEntity subtopic) {
        this.subtopic = subtopic;
    }
}
