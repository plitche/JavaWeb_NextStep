package next.dao;

import core.jdbc.JdbcTemplate;
import core.jdbc.RowMapper;
import next.model.Question;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class QuestionDao {

    public List<Question> findAll() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        String sql = "SELECT questionId, writer, title, contents, createDate, countOfAnswer FROM QUESTIONS";

        RowMapper<Question> rm = new RowMapper<Question>() {
            @Override
            public Question mapRow(ResultSet rs) throws SQLException {
                return new Question(
                        rs.getLong("questionId")
                        , rs.getString("writer")
                        , rs.getString("title")
                        , rs.getString("contents")
                        , LocalDateTime.parse(rs.getString("createDate"))
                        , rs.getInt("countOfAnswer")
                );
            }
        };

        return jdbcTemplate.query(sql, rm);
    }

    public Question findById(Long quesitonSeq) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        String sql = "SELECT questionId, writer, title, contents, createDate, countOfAnswer FROM questions WHERE questionId = ?";

        RowMapper<Question> rm = new RowMapper<Question>() {
            @Override
            public Question mapRow(ResultSet rs) throws SQLException {
                return new Question(
                        rs.getLong("questionId")
                        , rs.getString("writer")
                        , rs.getString("title")
                        , rs.getString("contents")
                        , LocalDateTime.parse(rs.getString("createDate"))
                        , rs.getInt("countOfAnswer")
                );
            }
        };

        return jdbcTemplate.queryForObject(sql, rm);
    }
}
