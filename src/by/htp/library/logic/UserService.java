package by.htp.library.logic;

import java.util.List;

import by.htp.library.model.User;

public interface UserService {

	boolean createUser(String login, String password);

	User authorizeUser(String login, String password);

	List<User> getUsers();

	boolean getUserLogin(String login);

	User getUserInfo(int id);

}
