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
        PreparedStatementSetter pss = new PreparedStatementSetter() {
            @Override
            public void setParameters(PreparedStatement pstmt) throws SQLException {
                pstmt.setString(1, user.getUserId());
                pstmt.setString(2, user.getPassword());
                pstmt.setString(3, user.getName());
                pstmt.setString(4, user.getEmail());
            }
        };

        JdbcTemplate template = new JdbcTemplate() {};
        String sql = "INSERT INTO USERS VALUES (?, ?, ?, ?)";
        template.executeUpdate(sql, pss);
    }

    public void delete(User user) throws SQLException {
        PreparedStatementSetter pss = new PreparedStatementSetter() {
            @Override
            public void setParameters(PreparedStatement pstmt) throws SQLException {
                pstmt.setString(1, user.getUserId());
            }
        };

        JdbcTemplate template = new JdbcTemplate() {};
        String sql = "delete from USERS where userId = ?";
        template.executeUpdate(sql, pss);
    }

    public void update(User user) throws SQLException {
        PreparedStatementSetter pss = new PreparedStatementSetter() {
            @Override
            public void setParameters(PreparedStatement pstmt) throws SQLException {
                pstmt.setString(1, user.getPassword());
                pstmt.setString(2, user.getName());
                pstmt.setString(3, user.getEmail());
                pstmt.setString(4, user.getUserId());
            }
        };

        JdbcTemplate template = new JdbcTemplate() {};
        String sql = "UPDATE USERS SET password = ?, name = ?, email = ? WHERE userID = ?";
        template.executeUpdate(sql, pss);
    }

    public List<User> findAll() throws SQLException {
        PreparedStatementSetter pss = new PreparedStatementSetter() {
            @Override
            public void setParameters(PreparedStatement pstmt) throws SQLException {

            }
        };

        RowMapper rm = new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs) throws SQLException {
                List<User> userList = new ArrayList<>();

                while(rs.next()) {
                    User user = new User(
                            rs.getString("userId"),
                            rs.getString("password"),
                            rs.getString("name"),
                            rs.getString("email")
                    );
                    userList.add(user);
                }

                return userList;
            }
        };

        JdbcTemplate template = new JdbcTemplate() {};
        String sql = "SELECT userId, password, name, email FROM USERS";
        return (List<User>) template.executeQuery(sql, pss, rm);
    }

    public User findByUserId(String userId) throws SQLException {
        PreparedStatementSetter pss = new PreparedStatementSetter() {
            @Override
            public void setParameters(PreparedStatement pstmt) throws SQLException {
                pstmt.setString(1, userId);
            }
        };

        RowMapper rm = new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs) throws SQLException {
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
        return (User) template.executeQuery(sql, pss, rm);
    }

}
