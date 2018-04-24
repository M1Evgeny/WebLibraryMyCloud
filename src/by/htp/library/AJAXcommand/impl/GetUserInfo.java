package by.htp.library.AJAXcommand.impl;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

import by.htp.library.AJAXcommand.AjaxActionCommand;
import by.htp.library.logic.UserService;
import by.htp.library.logic.impl.UserServiceImpl;

public class GetUserInfo implements AjaxActionCommand {

	//private static final String PARAM_NAME_LOGIN = "login";
	private static final String PARAM_ID = "id";
	UserService service = new UserServiceImpl();

	@Override
	public String execute(HttpServletRequest request) {
		System.out.println("GetUserInfo");
		int id = Integer.parseInt(request.getParameter(PARAM_ID));
		System.out.println("id GetUserInfo = " + id);
		return new Gson().toJson(service.getUserInfo(id));
	}

}
