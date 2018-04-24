package by.htp.library.AJAXcommand.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import by.htp.library.AJAXcommand.AjaxActionCommand;
import by.htp.library.model.User;

public class UserProfile implements AjaxActionCommand {
	private static final String USER = "user";

	@Override
	public String execute(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(USER);
		System.out.println("UserProfile = " + user);
		return new Gson().toJson(user);
	}

}
