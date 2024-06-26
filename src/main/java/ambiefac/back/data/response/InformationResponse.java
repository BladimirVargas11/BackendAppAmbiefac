package ambiefac.back.data.response;

public class InformationResponse {

    private Long information_id;
    private String content;
   private String title;
    private String type;
    private Long position;


    public InformationResponse(){}


    public InformationResponse(Long information_id, String content, String type, Long position,String title) {
        this.information_id = information_id;
        this.content = content;
        this.type = type;
        this.title = title;
        this.position = position;
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


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
