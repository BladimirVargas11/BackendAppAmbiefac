package ambiefac.back.data.request;

public class InformationRequestSave {

    private String content;
    private String hasVideo;
    private String linkVideo;
    private String type;
    private Long position;
    private Long idSubtopic;

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

    public Long getIdSubtopic() {
        return idSubtopic;
    }

    public void setIdSubtopic(Long idSubtopic) {
        this.idSubtopic = idSubtopic;
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
