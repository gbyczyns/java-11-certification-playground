package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.sql.DataSource;

public class JdbcTest {
	public static void main(String[] args) throws SQLException {
		Connection connection = DriverManager.getConnection("");
	}
}
