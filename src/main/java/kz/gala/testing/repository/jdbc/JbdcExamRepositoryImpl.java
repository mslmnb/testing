package kz.gala.testing.repository.jdbc;

import kz.gala.testing.model.Exam;
import kz.gala.testing.model.ExamPrimaryKey;
import kz.gala.testing.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JbdcExamRepositoryImpl implements ExamRepository {

    //private static final BeanPropertyRowMapper<Exam> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Exam.class);
    private static final ExamMapper ROW_MAPPER = new ExamMapper();
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JbdcExamRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Exam> getNextFrom(int questionId, int userId) {
        return jdbcTemplate.query("SELECT * from exam WHERE user_id=? AND question_id>=? ORDER BY question_id LIMIT 3",ROW_MAPPER,userId,questionId);
    }

    @Override
    public List<Exam> getPreviousFrom(int questionId, int userId) {
        return jdbcTemplate.query("SELECT * from exam WHERE user_id=? AND question_id<=? ORDER BY question_id DESC LIMIT 3",ROW_MAPPER,userId,questionId);
    }

    @Override
    public List<Exam> getFirst(int userId) {
        return jdbcTemplate.query("SELECT * from exam WHERE user_id=? ORDER BY question_id LIMIT 2",ROW_MAPPER,userId);
    }

    @Override
    public List<Exam> getLast(int userId) {
        return jdbcTemplate.query("SELECT * from exam WHERE user_id=? ORDER BY question_id DESC LIMIT 2",ROW_MAPPER,userId);
    }

    @Transactional
    @Override
    public Exam update(Exam exam, int userAnswerId, int userId) {
        if (exam.getUserId()!=userId)
            return null;
        if (jdbcTemplate.update("UPDATE exam SET user_answer_id=? WHERE user_id=? AND question_id=?"
                                , userAnswerId, userId, exam.getQuestionId()) == 0) {
            return null;
        }
        exam.setUserAnswerId(userAnswerId);
        return exam;
    }

    @Override
    public Exam get(int questionId, int userId) {
        List<Exam> exams = jdbcTemplate.query("SELECT * from exam WHERE user_id=? AND question_id=?",ROW_MAPPER,userId,questionId);
        return DataAccessUtils.singleResult(exams);
    }

    @Override
    public List<Exam> getAll(int userId) {
        return jdbcTemplate.query("SELECT * from exam WHERE user_id=? ORDER BY question_id",ROW_MAPPER,userId);
    }

    @Transactional
    @Override
    public int insert(int userId, int themeId) {
        return jdbcTemplate.update("INSERT INTO exam (user_id, question_id, user_answer_id) SELECT ?, q.id, null FROM questions q WHERE q.theme_id=?", userId, themeId);
    }

    @Transactional
    @Override
    public int delete(int userId) {
        return jdbcTemplate.update("DELETE FROM exam WHERE user_id=?", userId);
    }


}
