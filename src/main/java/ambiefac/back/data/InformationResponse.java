package ambiefac.back.data;

public class InformationResponse {

    private Long information_id;
    private String content;

    public InformationResponse(){}
    public InformationResponse(Long information_id, String content) {
        this.information_id = information_id;
        this.content = content;
    }

    public Long getInformation_id() {
        return information_id;
    }

    public void setInformation_id(Long information_id) {
        this.information_id = information_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
