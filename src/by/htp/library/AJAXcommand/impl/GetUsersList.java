package by.htp.library.AJAXcommand.impl;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

import by.htp.library.AJAXcommand.AjaxActionCommand;
import by.htp.library.logic.UserService;
import by.htp.library.logic.impl.UserServiceImpl;

public class GetUsersList implements AjaxActionCommand {
	
	UserService service = new UserServiceImpl();

	@Override
	public String execute(HttpServletRequest request) {
		return new Gson().toJson(service.getUsers());
	}

}
