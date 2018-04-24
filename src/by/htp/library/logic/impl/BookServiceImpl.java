package by.htp.library.logic.impl;

import java.util.List;

import by.htp.library.dao.BookDao;
import by.htp.library.dao.impl.BookDaoMySqlImpl;
import by.htp.library.logic.BookService;
import by.htp.library.model.Book;
import by.htp.library.model.User;

public class BookServiceImpl implements BookService {

	private BookDao service = new BookDaoMySqlImpl();

	@Override
	public boolean createBook(String title, String author, int year) {
		Book book = new Book(title, author, year);
		return service.create(book);
	}

	@Override
	public List<Book> getCatalog() {
		return service.readAll();
	}

	public List<Book> getAvailableCatalog() {
		return service.readUncheckedBooks();
	}

	public List<Book> getUserBooks(User user) {
		return service.readUserBooks(user);
	}

	public List<Book> getUserBooksHistory(User user) {
		return service.readUserBooksHistory(user);
	}

	public List<Book> getUserOverdueBooks(User user) {
		return service.readOverdueUserBooks(user);
	}

	public Book getBookInfo(int id) {
		return service.read(id);
	}

	public boolean deleteBook(Book book) {
		return service.delete(book);
	}

	public boolean updateBook(Book book) {
		return service.update(book);
	}

	public boolean checkOutBook(Book book, User user) {
		service.checkOutBookQuantity(book);
		return service.checkOutBook(user, book);
	}

	public boolean checkInBook(Book book, User user) {
		service.checkInBookQuantity(book);
		return service.checkInBook(user, book);
	}

}
