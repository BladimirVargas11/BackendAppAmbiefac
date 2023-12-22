package ambiefac.back.data.response;

import java.util.Date;
import java.util.List;

public class ExamResponse {

    private Long idExam;
    private Date examDate;

    private List<QuestionsResponse> questions;

    public Long getIdExam() {
        return idExam;
    }

    public void setIdExam(Long idExam) {
        this.idExam = idExam;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public List<QuestionsResponse> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionsResponse> questions) {
        this.questions = questions;
    }
}
