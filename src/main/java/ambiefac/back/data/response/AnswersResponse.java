package ambiefac.back.data.response;

import java.util.List;

public class AnswersResponse {

   private List<AnswerResponse> answers;
   private double score;

    public List<AnswerResponse> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerResponse> answers) {
        this.answers = answers;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
