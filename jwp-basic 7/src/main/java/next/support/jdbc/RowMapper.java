package next.support.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface // 이 인터페이스는 아래 메서드 하나만을 가진다. 함수처럼 사용 가능
public interface RowMapper<T> {
    T mapRow(ResultSet rs) throws SQLException;
}
