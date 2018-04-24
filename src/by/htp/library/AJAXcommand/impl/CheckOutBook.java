package by.htp.library.AJAXcommand.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.htp.library.AJAXcommand.AjaxActionCommand;
import by.htp.library.logic.BookService;
import by.htp.library.logic.impl.BookServiceImpl;
import by.htp.library.model.Book;
import by.htp.library.model.User;

public class CheckOutBook implements AjaxActionCommand {
	private static final String USER = "user";
	private static final String PARAM_BOOK_ID = "id";
	BookService service = new BookServiceImpl();

	@Override
	public String execute(HttpServletRequest request) {
     String result = "false";
     HttpSession session = request.getSession();
     User user = (User) session.getAttribute(USER);
     int id = Integer.parseInt(request.getParameter(PARAM_BOOK_ID));
     Book book = new Book(id);
     System.out.println("CheckOutBook " +id);
     if(service.checkOutBook(book, user)) {
    	 result = "true";
     }
		return result;
	}

}
