package ambiefac.back.domain.dtos.exam;

import lombok.Data;

import java.util.List;
@Data
public class UpdateQuestionsListDto {

    private List<UpdateQuestionDto> questions;

    public List<UpdateQuestionDto> getQuestions() {
        return questions;
    }

    public void setQuestions(List<UpdateQuestionDto> questions) {
        this.questions = questions;
    }
}
