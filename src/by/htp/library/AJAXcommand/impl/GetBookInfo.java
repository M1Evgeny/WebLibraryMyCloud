package by.htp.library.AJAXcommand.impl;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

import by.htp.library.AJAXcommand.AjaxActionCommand;
import by.htp.library.logic.BookService;
import by.htp.library.logic.impl.BookServiceImpl;

public class GetBookInfo implements AjaxActionCommand {
	
	private static final String PARAM_ID = "id";
	BookService service = new BookServiceImpl();

	@Override
	public String execute(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter(PARAM_ID));
		System.out.println("getbookinfo id = "+id);
		return new Gson().toJson(service.getBookInfo(id));
	}

}
