package by.htp.library.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection implements AutoCloseable {

	private Connection connection;

	public Connection getConnection() {

		try {
			String url = "jdbc:mysql://node51578-env-1995265.mycloud.by/Library?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
			String login = "root";
			String pass = "FARokx45128";
			String driver = "com.mysql.cj.jdbc.Driver";

			Class.forName(driver);

			connection = DriverManager.getConnection(url, login, pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	@Override
	public void close() throws Exception {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
