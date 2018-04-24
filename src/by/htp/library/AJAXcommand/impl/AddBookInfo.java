package by.htp.library.AJAXcommand.impl;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

import by.htp.library.AJAXcommand.AjaxActionCommand;
import by.htp.library.logic.BookService;
import by.htp.library.logic.impl.BookServiceImpl;

public class AddBookInfo implements AjaxActionCommand {
	private static final String PARAM_NAME_TITLE = "title";
	private static final String PARAM_NAME_AUTHOR = "author";
	private static final String PARAM_NAME_PUBLISH_YEAR = "year";
	BookService service = new BookServiceImpl();

	@Override
	public String execute(HttpServletRequest request) {
		String title = request.getParameter(PARAM_NAME_TITLE);
		String author = request.getParameter(PARAM_NAME_AUTHOR);
		int year = Integer.parseInt(request.getParameter(PARAM_NAME_PUBLISH_YEAR));
		System.out.println("AddBookInfo " + title + " " + year);
		return new Gson().toJson(service.createBook(title, author, year));
	}

}
