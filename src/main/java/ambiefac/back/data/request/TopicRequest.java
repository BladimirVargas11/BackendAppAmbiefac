package ambiefac.back.data.request;


import java.util.List;

public class TopicRequest {

    private String topicName;
    private String topicDescription;
    private String time;

   private List<SubtopicRequest> subtopics;



    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicDescription() {
        return topicDescription;
    }

    public void setTopicDescription(String topicDescription) {
        this.topicDescription = topicDescription;
    }

    public List<SubtopicRequest> getSubtopics() {
        return subtopics;
    }

    public void setSubtopics(List<SubtopicRequest> subtopics) {
        this.subtopics = subtopics;
    }


}
