package by.htp.library.AJAXcommand.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import by.htp.library.AJAXcommand.AjaxActionCommand;
import by.htp.library.logic.BookService;
import by.htp.library.logic.impl.BookServiceImpl;
import by.htp.library.model.User;

public class GetMyBooks implements AjaxActionCommand {
	BookService service = new BookServiceImpl();
	private static final String PARAM_USER_ROLE = "user";

	@Override
	public String execute(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(PARAM_USER_ROLE);
		return new Gson().toJson(service.getUserBooks(user));
	}

}
