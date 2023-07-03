package next.dao;

import core.jdbc.ConnectionManager;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

public class ConnectionManagerTest {

    @Test
    public void connection() {
        Connection con = ConnectionManager.getConnection();
        Assert.assertNotNull(con);
    }
}
