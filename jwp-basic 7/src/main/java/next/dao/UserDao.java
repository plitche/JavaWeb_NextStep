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

// UserDao 클래스를 통해 데이터베이스 접근 로직 구현
// 데이터베이스에 대한 접근 로직 처리르 담당하는 객체를 별도로 분리하는것을 추천
// 이 객체를 DAO(Data Access Object)라 한다.
public class UserDao {

    private List<User> userList = new ArrayList<User>();
    private User user = null;


    private void common(QueryType queryType, Connection con, PreparedStatement pstmt) throws SQLException {
        try {
            String queryString = queryType.getQueryType();

            if ("INSERT".equals(queryString)) {
                pstmt.executeUpdate();
            } else if ("SELECT_ALL".equals(queryString)) {
                ResultSet rs = null;

                rs = pstmt.executeQuery();
                while(rs.next()) {
                    User user = new User(
                            rs.getString("userId"),
                            rs.getString("password"),
                            rs.getString("name"),
                            rs.getString("email")
                    );
                    userList.add(user);
                }
            } else if ("UPDATE".equals(queryString)) {
                pstmt.executeUpdate();
            } else if ("DELETE".equals(queryString)) {
                ResultSet rs = null;

                if (rs.next()) {
                    user = new User(
                            rs.getString("userId"),
                            rs.getString("password"),
                            rs.getString("name"),
                            rs.getString("email")
                    );
                }
            }

        } finally {
            if (pstmt != null) {
                pstmt.close();
            }

            if (con != null) {
                con.close();
            }
        }
    }

    public void insert(User user) throws SQLException {

        Connection con = null;
        PreparedStatement pstmt = null;

        con = ConnectionManager.getConnection();
        String sql = "INSERT INTO USERS VALUES (?, ?, ?, ?)";
        pstmt = con.prepareStatement(sql);
        pstmt.setString(1, user.getUserId());
        pstmt.setString(2, user.getPassword());
        pstmt.setString(3, user.getName());
        pstmt.setString(4, user.getEmail());

        common(QueryType.INSERT, con, pstmt);
    }

    public void update(User user) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        con = ConnectionManager.getConnection();
        String sql = "UPDATE USERS " +
                     "SET password = ?, name = ?, email = ? " +
                     "WHERE userID = ?";
        pstmt = con.prepareStatement(sql);

        pstmt.setString(1, user.getPassword());
        pstmt.setString(2, user.getName());
        pstmt.setString(3, user.getEmail());
        pstmt.setString(4, user.getUserId());

        common(QueryType.UPDATE, con, pstmt);
    }

    public List<User> findAll() throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        con = ConnectionManager.getConnection();
        String sql = "SELECT userId, password, name, email FROM USERS";
        pstmt = con.prepareStatement(sql);

        common(QueryType.UPDATE, con, pstmt);
        return this.userList;
    }

    public User findByUserId(String userId) throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        con = ConnectionManager.getConnection();
        String sql = "SELECT userId, password, name, email FROM USERS WHERE userid=?";
        pstmt = con.prepareStatement(sql);
        pstmt.setString(1, userId);

        return this.user;
    }
}
