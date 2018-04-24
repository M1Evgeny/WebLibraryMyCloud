package by.htp.library.command.impl;

import javax.servlet.http.HttpServletRequest;

import by.htp.library.command.ActionCommand;
import by.htp.library.logic.UserService;
import by.htp.library.logic.impl.UserServiceImpl;

import static by.htp.library.util.ControllerConstantPool.*;

public class SignUpCommand implements ActionCommand {
	private static final String PARAM_NAME_LOGIN = "login";
	private static final String PARAM_NAME_PASSWORD = "password";
	UserService service = new UserServiceImpl();

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String login = request.getParameter(PARAM_NAME_LOGIN);
		String password = request.getParameter(PARAM_NAME_PASSWORD);
		if (service.createUser(login, password)) {
			page = PAGE_LOGIN;
		} else {
			page = PAGE_INDEX;
		}
		return page;
	}

}
