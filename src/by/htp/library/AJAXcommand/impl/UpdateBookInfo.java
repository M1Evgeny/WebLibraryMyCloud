package by.htp.library.AJAXcommand.impl;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

import by.htp.library.AJAXcommand.AjaxActionCommand;
import by.htp.library.logic.BookService;
import by.htp.library.logic.impl.BookServiceImpl;
import by.htp.library.model.Book;

public class UpdateBookInfo implements AjaxActionCommand {
	private static final String PARAM_BOOK_TITLE = "title";
	private static final String PARAM_BOOK_AUTHOR = "author";
	private static final String PARAM_BOOK_PUBLISH_YEAR = "year";
	private static final String PARAM_BOOK_ID = "id";
	BookService service = new BookServiceImpl();

	@Override
	public String execute(HttpServletRequest request) {
		String title = request.getParameter(PARAM_BOOK_TITLE);
		String author = request.getParameter(PARAM_BOOK_AUTHOR);
		int year = Integer.parseInt(request.getParameter(PARAM_BOOK_PUBLISH_YEAR));
		int id = Integer.parseInt(request.getParameter(PARAM_BOOK_ID));
		System.out.println(id +" id value");
		Book book = new Book(id, title, author, year);
		return new Gson().toJson(service.updateBook(book));
	}

}
