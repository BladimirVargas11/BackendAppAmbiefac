package ambiefac.back.data.request;


import java.util.List;

public class SubtopicRequest {

    private String nameSubtopic;
    private List<InformationRequest> information;


    public String getNameSubtopic() {
        return nameSubtopic;
    }

    public void setNameSubtopic(String nameSubtopic) {
        this.nameSubtopic = nameSubtopic;
    }

    public List<InformationRequest> getInformation() {
        return information;
    }

    public void setInformation(List<InformationRequest> information) {
        this.information = information;
    }
}
