package kz.gala.testing.repository.jdbc;


import kz.gala.testing.model.Exam;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

class ExamMapper implements RowMapper<Exam> {
    @Override
    public Exam mapRow(ResultSet rs, int rowNum) throws SQLException {
        Integer questionId = rs.getInt("question_id");
        Integer userId = rs.getInt("user_id");
        Integer userAnswerEnums = rs.getInt("user_answer_enums");
        return new Exam(userId, questionId, userAnswerEnums);
    }

}
