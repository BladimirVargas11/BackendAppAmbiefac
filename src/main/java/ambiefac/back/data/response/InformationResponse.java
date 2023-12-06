package ambiefac.back.data.response;

public class InformationResponse {

    private Long information_id;
    private String content;
    private String has_video;
    private String link_video;

    public InformationResponse(){}


    public InformationResponse(Long information_id, String content, String has_video, String link_video) {
        this.information_id = information_id;
        this.content = content;
        this.has_video = has_video;
        this.link_video = link_video;
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

    public String getHas_video() {
        return has_video;
    }

    public void setHas_video(String has_video) {
        this.has_video = has_video;
    }

    public String getLink_video() {
        return link_video;
    }

    public void setLink_video(String link_video) {
        this.link_video = link_video;
    }
}
