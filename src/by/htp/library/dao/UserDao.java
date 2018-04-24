package by.htp.library.dao;

import java.util.List;

import by.htp.library.model.User;



public interface UserDao extends BaseDao<User> {
	
	boolean create(User user);

	User read(User user);

	List<User> readAll();

	List<String> readUserLogin();

	

}
