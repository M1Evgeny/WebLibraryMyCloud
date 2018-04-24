package by.htp.library.command.impl;

import static by.htp.library.util.ControllerConstantPool.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.htp.library.command.ActionCommand;
import by.htp.library.logic.BookService;
import by.htp.library.logic.impl.BookServiceImpl;
import by.htp.library.logic.impl.UserServiceImpl;
import by.htp.library.model.Book;
import by.htp.library.model.User;

public class LoginCommand implements ActionCommand {

	UserServiceImpl service = new UserServiceImpl();
	BookService bookService = new BookServiceImpl();
	private static final String PARAM_NAME_LOGIN = "login";
	private static final String PARAM_NAME_PASSWORD = "password";
	private static final String PARAM_ADMIN_ROLE = "admin";
	private static final String PARAM_USER_ROLE = "user";
	private static final int MAX_INACTIVE_INTERVAL = 1200;

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String login = request.getParameter(PARAM_NAME_LOGIN);
		String password = request.getParameter(PARAM_NAME_PASSWORD);
		User user = service.authorizeUser(login, password);

		if (user != null && user.getRole().equals(PARAM_ADMIN_ROLE)) {
			page = PAGE_ADMIN_PROFILE;
			addUserToSession(user, request);
		} else if (user != null && user.getRole().equals(PARAM_USER_ROLE)) {
			page = checkOverdueBooks(user, request);
			addUserToSession(user, request);
		} else {
			page = PAGE_LOGIN;
		}
		return page;
	}

	private void addUserToSession(User user, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute(PARAM_USER_ROLE, user);
		session.setMaxInactiveInterval(MAX_INACTIVE_INTERVAL);
	}

	private String checkOverdueBooks(User user, HttpServletRequest request) {
		String page = PAGE_USER_PROFILE;
		List<Book> catalog = bookService.getUserOverdueBooks(user);
		if (!catalog.isEmpty()) {
			page = PAGE_USER_OVERDUE_PROFILE;
			request.setAttribute("catalog", catalog);
		}
		return page;
	}
}
