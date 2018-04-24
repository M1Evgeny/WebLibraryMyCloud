package by.htp.library.AJAXcommand.impl;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

import by.htp.library.AJAXcommand.AjaxActionCommand;
import by.htp.library.logic.UserService;
import by.htp.library.logic.impl.UserServiceImpl;

public class CheckUserNameAjaxCommand implements AjaxActionCommand {
	UserService service = new UserServiceImpl();
	private static final String PARAM_NAME_LOGIN = "login";

	@Override
	public String execute(HttpServletRequest request) {
		String login = request.getParameter(PARAM_NAME_LOGIN);
		return new Gson().toJson(service.getUserLogin(login));
	}

}
