package ambiefac.back.data.response;

import java.util.List;

public class QuestionsResponse {

    private Long questionsId;
    private String questionStatement;

    private List<AnswerQuestionResponse> answers;


    public Long getQuestionsId() {
        return questionsId;
    }

    public void setQuestionsId(Long questionsId) {
        this.questionsId = questionsId;
    }

    public String getQuestionStatement() {
        return questionStatement;
    }

    public void setQuestionStatement(String questionStatement) {
        this.questionStatement = questionStatement;
    }

    public List<AnswerQuestionResponse> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerQuestionResponse> answers) {
        this.answers = answers;
    }
}
