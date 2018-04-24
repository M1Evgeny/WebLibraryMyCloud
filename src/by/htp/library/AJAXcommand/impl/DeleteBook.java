package by.htp.library.AJAXcommand.impl;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

import by.htp.library.AJAXcommand.AjaxActionCommand;
import by.htp.library.logic.BookService;
import by.htp.library.logic.impl.BookServiceImpl;
import by.htp.library.model.Book;

public class DeleteBook implements AjaxActionCommand {

	private static final String PARAM_BOOK_ID = "id";
	BookService service = new BookServiceImpl();

	@Override
	public String execute(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter(PARAM_BOOK_ID));
		Book book = new Book(id);
		return new Gson().toJson(service.deleteBook(book));
	}

}
