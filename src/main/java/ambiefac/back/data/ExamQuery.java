package ambiefac.back.data;

import ambiefac.back.data.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ExamQuery {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ExamQuery(){}

    public ExamResponse findExamWithQuestions(@Param("id") Long id) {
        String sql = "SELECT exam.id as exam_id, exam.exam_date, exam_question.id as question_id, exam_question.question_statement, \n" +
                "question_answer.answer_text, question_answer.id, question_answer.is_correct\n" +
                "FROM exam LEFT JOIN exam_question ON exam.id = exam_question.exam\n" +
                "LEFT JOIN question_answer ON question_answer.question = exam_question.id\n" +
                "WHERE exam.id = ?\n";
        Map<Long, ExamResponse> examMap = new HashMap<>();

        jdbcTemplate.query(sql, new Object[]{id}, (rs, rowNum) -> {
            Long examId = rs.getLong("exam_id");

            ExamResponse examResponse;
            if (!examMap.containsKey(examId)) {
                examResponse = new ExamResponse();
                examResponse.setIdExam(examId);
                examResponse.setExamDate(rs.getDate("exam_date"));
                examResponse.setQuestions(new ArrayList<>());
                examMap.put(examId, examResponse);
            } else {
                examResponse = examMap.get(examId);
            }

            Long questionId = rs.getLong("question_id");
            QuestionsResponse questionsResponse = findQuestionById(examResponse.getQuestions(), questionId);

            if (questionsResponse == null) {
                questionsResponse = new QuestionsResponse();
                questionsResponse.setQuestionsId(questionId);
                questionsResponse.setQuestionStatement(rs.getString("question_statement"));
                questionsResponse.setAnswers(new ArrayList<>());
                examResponse.getQuestions().add(questionsResponse);
            }

            AnswerQuestionResponse answerQuestionResponse = new AnswerQuestionResponse();
            answerQuestionResponse.setId(rs.getLong("id"));
            answerQuestionResponse.setAnswerText(rs.getString("answer_text"));
            answerQuestionResponse.setCorrect(rs.getBoolean("is_correct"));

            questionsResponse.getAnswers().add(answerQuestionResponse);

            return null;
        });

        List<ExamResponse> resultList = new ArrayList<>(examMap.values());
        return resultList.isEmpty() ? null : resultList.get(0);
    }

    private QuestionsResponse findQuestionById(List<QuestionsResponse> questions, Long questionId) {
        for (QuestionsResponse question : questions) {
            if (question.getQuestionsId().equals(questionId)) {
                return question;
            }
        }
        return null;
    }
}
