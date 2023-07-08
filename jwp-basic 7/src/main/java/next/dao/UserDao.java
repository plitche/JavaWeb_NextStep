package next.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import next.model.User;
import next.support.JdbcTemplate;
import next.support.PreparedStatementSetter;
import next.support.RowMapper;

// UserDao 클래스를 통해 데이터베이스 접근 로직 구현
// 데이터베이스에 대한 접근 로직 처리르 담당하는 객체를 별도로 분리하는것을 추천
// 이 객체를 DAO(Data Access Object)라 한다.
public class UserDao {

    public void insert(User user) throws SQLException {
        JdbcTemplate template = new JdbcTemplate() {};
        String sql = "INSERT INTO USERS VALUES (?, ?, ?, ?)";
        template.executeUpdate(sql, user.getUserId(), user.getPassword(), user.getName(), user.getEmail());
    }

    public void delete(User user) throws SQLException {
        JdbcTemplate template = new JdbcTemplate() {};
        String sql = "delete from USERS where userId = ?";
        template.executeUpdate(sql, user.getUserId());
    }

    public void update(User user) throws SQLException {
        JdbcTemplate template = new JdbcTemplate() {};
        String sql = "UPDATE USERS SET password = ?, name = ?, email = ? WHERE userID = ?";
        template.executeUpdate(sql, user.getPassword(), user.getName(), user.getEmail(), user.getUserId());
    }

    public List<User> findAll() throws SQLException {
        RowMapper<User> rm = new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs) throws SQLException {
                return new User(
                        rs.getString("userId"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("email")
                );
            }
        };

        JdbcTemplate template = new JdbcTemplate() {};
        String sql = "SELECT userId, password, name, email FROM USERS";
        return template.list(sql, rm);
    }

    public User findByUserId(String userId) throws SQLException {
        RowMapper<User> rm = new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs) throws SQLException {
                return new User(
                        rs.getString("userId"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("email")
                );
            }
        };

        JdbcTemplate template = new JdbcTemplate() {};
        String sql = "select * from USERS where userId = ?";
        return template.executeQuery(sql, rm, userId);
    }

}
