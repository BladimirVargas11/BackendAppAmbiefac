package ambiefac.back.domain.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "information")
public class InformationEntity {

    @Id
    private Long id;
    private String content;
    private String has_video;
    private String link_video;

    @OneToOne(targetEntity = SubtopicEntity.class )
    @JoinColumn(name = "subtopic")
    private SubtopicEntity subtopic;
}
