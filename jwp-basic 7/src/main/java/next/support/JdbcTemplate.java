package next.support;

import core.jdbc.ConnectionManager;
import next.dao.UserDao;
import next.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTemplate {

    public void executeUpdate(String sql, PreparedStatementSetter pss) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pss.setParameters(pstmt);

            pstmt.executeUpdate();
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        }
    }

    public void executeUpdate(String sql, Object... parameters) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement(sql);

            for (int i=0; i<parameters.length; i++) {
                Object param = parameters[i];
                pstmt.setObject(i+1, param);
            }

            pstmt.executeUpdate();
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        }
    }

    public <T> T executeQuery(String sql, RowMapper<T> rm, PreparedStatementSetter pss) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pss.setParameters(pstmt);

            rs = pstmt.executeQuery();
            if (!rs.next()) {
                return null;
            }

            return rm.mapRow(rs);
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        }
    }

    public <T> T executeQuery(String sql, RowMapper<T> rm, Object... parameters) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement(sql);

            for (int i=0; i<parameters.length; i++) {
                Object param = parameters[i];
                pstmt.setObject(i+1, param);
            }

            rs = pstmt.executeQuery();
            if (!rs.next()) {
                return null;
            }

            return rm.mapRow(rs);
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        }
    }

    // template method pattern
    // public abstract void setParameters(PreparedStatement pstmt) throws SQLException;
    // public abstract Object mapRow(ResultSet rs) throws SQLException;


}
