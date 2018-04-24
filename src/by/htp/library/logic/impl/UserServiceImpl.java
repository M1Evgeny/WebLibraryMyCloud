package by.htp.library.logic.impl;

import java.util.List;

import by.htp.library.dao.UserDao;
import by.htp.library.dao.impl.UserDaoDBImpl;
import by.htp.library.logic.UserService;
import by.htp.library.model.User;

public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoDBImpl();

	@Override
	public boolean createUser(String login, String password) {
		User user = new User(login, password);
		return userDao.create(user);
	}

	@Override
	public List<User> getUsers() {
		return userDao.readAll();
	}

	@Override
	public User authorizeUser(String login, String password) {
		User user = new User(login, password);
		return userDao.read(user);
	}

	public User getUserInfo(int id) {
		return userDao.read(id);
	}

	public boolean getUserLogin(String login) {
		boolean result = true;
		List<String> logins = userDao.readUserLogin();
		for (String s : logins) {
			if (s.equals(login)) {
				result = false;
			}
		}
		return result;
	}

}
