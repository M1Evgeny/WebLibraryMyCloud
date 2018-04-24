package by.htp.library.command.impl;

import static by.htp.library.util.ControllerConstantPool.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.htp.library.command.ActionCommand;
import by.htp.library.logic.BookService;
import by.htp.library.logic.impl.BookServiceImpl;
import by.htp.library.model.Book;
import by.htp.library.model.User;

public class CheckOverdueBooksCommand implements ActionCommand {
	private static final String USER = "user";
	BookService service = new BookServiceImpl();

	@Override
	public String execute(HttpServletRequest request) {
		int bookId =Integer.parseInt(request.getParameter("bookId"));
		Book book = new Book(bookId);
		HttpSession session = request.getSession();
	    User user = (User) session.getAttribute(USER);
		service.checkInBook(book,user);
		return checkOverdueBooks(user, request);
	}
	
	
	private String checkOverdueBooks(User user, HttpServletRequest request) {
		String page = PAGE_USER_PROFILE;
		List<Book> catalog = service.getUserOverdueBooks(user);
		if (!catalog.isEmpty()) {
			page = PAGE_USER_OVERDUE_PROFILE;
			request.setAttribute("catalog", catalog);
		}
		return page;
	}

}
