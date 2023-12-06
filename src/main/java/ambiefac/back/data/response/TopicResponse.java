package ambiefac.back.data.response;

import ambiefac.back.data.response.SubtopicResponse;

import java.util.List;

public class TopicResponse {

    private Long id;
    private String name;

    private List<SubtopicResponse> subtopic;

    public TopicResponse(){}

    public TopicResponse(Long id, String name, List<SubtopicResponse> subtopic) {
        this.id = id;
        this.name = name;
        this.subtopic = subtopic;
    }

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

    public List<SubtopicResponse> getSubtopic() {
        return subtopic;
    }

    public void setSubtopic(List<SubtopicResponse> subtopic) {
        this.subtopic = subtopic;
    }
}
