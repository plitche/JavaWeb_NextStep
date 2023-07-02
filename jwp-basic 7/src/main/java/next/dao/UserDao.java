package next.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import core.jdbc.ConnectionManager;
import next.model.User;
import next.support.JdbcTemplate;

// UserDao 클래스를 통해 데이터베이스 접근 로직 구현
// 데이터베이스에 대한 접근 로직 처리르 담당하는 객체를 별도로 분리하는것을 추천
// 이 객체를 DAO(Data Access Object)라 한다.
public class UserDao {

    private Connection con;
    private PreparedStatement pstmt;
    private ResultSet rs;

    private List<User> userList = new ArrayList<User>();
    private User user;

    private String init(QueryType queryType) {
        this.con = ConnectionManager.getConnection();

        String sql = "";
        String queryString = queryType.getQueryType();
        if ("INSERT".equals(queryString)) {
            sql = "INSERT INTO USERS VALUES (?, ?, ?, ?)";
        } else if ("UPDATE".equals(queryString)) {
            sql = "UPDATE USERS " +
                    "SET password = ?, name = ?, email = ? " +
                    "WHERE userID = ?";
        } else if ("SELECT_ALL".equals(queryString)) {
            sql = "SELECT userId, password, name, email FROM USERS";
        } else if ("SELECT_ONE".equals(queryString)) {
            sql = "SELECT userId, password, name, email FROM USERS WHERE userid = ?";
        }

        return sql;
    }

    private void common(QueryType queryType, String sql) throws SQLException {
        try {
            String queryString = queryType.getQueryType();

            if ("INSERT".equals(queryString)) {
                this.pstmt.executeUpdate();
            } else if ("SELECT_ALL".equals(queryString)) {
                this.rs = this.pstmt.executeQuery();
                while(rs.next()) {
                    User user = new User(
                            rs.getString("userId"),
                            rs.getString("password"),
                            rs.getString("name"),
                            rs.getString("email")
                    );
                    this.userList.add(user);
                }
            } else if ("UPDATE".equals(queryString)) {
                this.pstmt.executeUpdate();
            } else if ("SELECT_ONE".equals(queryString)) {
                this.rs = this.pstmt.executeQuery();
                if (rs.next()) {
                    this.user = new User(
                            rs.getString("userId"),
                            rs.getString("password"),
                            rs.getString("name"),
                            rs.getString("email")
                    );
                }
            }

        } finally {
            if (this.pstmt != null) {
                this.pstmt.close();
            }

            if (this.con != null) {
                this.con.close();
            }
        }
    }

    public void insert(User user) throws SQLException {
        JdbcTemplate template = new JdbcTemplate();
        template.addUser(user, this);
    }

    public void update(User user) throws SQLException {
        String sql = init(QueryType.UPDATE);

        this.pstmt = this.con.prepareStatement(sql);
        this.pstmt.setString(1, user.getPassword());
        this.pstmt.setString(2, user.getName());
        this.pstmt.setString(3, user.getEmail());
        this.pstmt.setString(4, user.getUserId());

        common(QueryType.UPDATE, sql);
    }

    public List<User> findAll() throws SQLException {
        String sql = init(QueryType.SELECT_ALL);

        this.pstmt = this.con.prepareStatement(sql);

        common(QueryType.SELECT_ALL, sql);
        return this.userList;
    }

    public User findByUserId(String userId) throws SQLException {
        String sql = init(QueryType.SELECT_ONE);

        this.pstmt = this.con.prepareStatement(sql);
        this.pstmt.setString(1, userId);

        common(QueryType.SELECT_ONE, sql);
        return this.user;
    }


    public String createQuery() {
        return "INSERT INTO USERS VALUES (?, ?, ?, ?)";
    }

    public void setParameters(User user, PreparedStatement pstmt) throws SQLException {
        this.pstmt.setString(1, user.getUserId());
        this.pstmt.setString(2, user.getPassword());
        this.pstmt.setString(3, user.getName());
        this.pstmt.setString(4, user.getEmail());
    }

}
