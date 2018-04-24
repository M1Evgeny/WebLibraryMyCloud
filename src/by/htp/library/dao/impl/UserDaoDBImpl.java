package by.htp.library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.htp.library.dao.UserDao;
import by.htp.library.model.User;

public class UserDaoDBImpl extends AbstractDaoMySqlImpl implements UserDao {

	private static final String SQL_INSERT_USER = "INSERT INTO users(login, password) values(?,?)";
	// private static final String SQL_SELECT_USER = "SELECT id, login, password,
	// FROM users WHERE login=? AND password=?";
	private static final String SQL_SELECT_LOGIN = "SELECT login FROM users";
	private static final String SQL_SELECT_USER = "SELECT id, login, password, role FROM users WHERE id=?";
	private static final String SQL_SELECT_AUTHORIZATION_USER = "SELECT id, login, password, role FROM users WHERE login=? AND password=?";
	private static final String SQL_SELECT_USER_ALL = "SELECT id, login, password, role FROM users";

	private ResultSet rs;

	@Override
	public boolean update(User entiy) {
		return false;
	}

	@Override
	public boolean delete(User entity) {
		return false;
	}

	@Override
	public boolean create(User user) {
		boolean result = false;
		try (Connection conn = mySqlConn.getConnection();
				PreparedStatement ps = conn.prepareStatement(SQL_INSERT_USER)) {
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ps.executeUpdate();
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public User read(int id) {
		User user = null;
		try (Connection conn = mySqlConn.getConnection();
				PreparedStatement ps = conn.prepareStatement(SQL_SELECT_USER);) {
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				user = buildUser(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return user;
	}

	@Override
	public User read(User user) {
		User userDB = null;
		try (Connection conn = mySqlConn.getConnection();
				PreparedStatement ps = conn.prepareStatement(SQL_SELECT_AUTHORIZATION_USER);) {
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			rs = ps.executeQuery();
			while (rs.next()) {
				userDB = buildUser(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return userDB;
	}

	@Override
	public List<User> readAll() {
		List<User> users = new ArrayList<>();
		try (Connection conn = mySqlConn.getConnection();
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(SQL_SELECT_USER_ALL)) {
			while (rs.next()) {
				users.add(buildUser(rs));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	public List<String> readUserLogin() {
		List<String> logins = new ArrayList<>();
		try (Connection conn = mySqlConn.getConnection();
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(SQL_SELECT_LOGIN)) {
			while (rs.next()) {
				logins.add(rs.getString(USER_LOGIN));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return logins;
	}

	private User buildUser(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getInt(USER_ID));
		user.setName(rs.getString(USER_LOGIN));
		user.setPassword(rs.getString(USER_PASS));
		user.setRole(rs.getString(USER_ROLE));
		return user;
	}

}
