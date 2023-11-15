package ambiefac.back.data;

import java.util.List;

public class SubtopicResponse {

    private Long subtopic_id;
    private String subtopic_name;

    private List<InformationResponse> information;

    public SubtopicResponse(){}

    public SubtopicResponse(Long subtopic_id, String subtopic_name, List<InformationResponse> information) {
        this.subtopic_id = subtopic_id;
        this.subtopic_name = subtopic_name;
        this.information = information;
    }

    public Long getSubtopic_id() {
        return subtopic_id;
    }

    public void setSubtopic_id(Long subtopic_id) {
        this.subtopic_id = subtopic_id;
    }

    public String getSubtopic_name() {
        return subtopic_name;
    }

    public void setSubtopic_name(String subtopic_name) {
        this.subtopic_name = subtopic_name;
    }

    public List<InformationResponse> getInformation() {
        return information;
    }

    public void setInformation(List<InformationResponse> information) {
        this.information = information;
    }
}
