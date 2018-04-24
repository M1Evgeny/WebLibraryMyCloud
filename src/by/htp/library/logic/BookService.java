package by.htp.library.logic;

import java.util.List;

import by.htp.library.model.Book;
import by.htp.library.model.User;

public interface BookService {
	boolean createBook(String title, String author, int year);

	List<Book> getCatalog();

	boolean checkInBook(Book book, User user);

	List<Book> getUserOverdueBooks(User user);

	boolean checkOutBook(Book book, User user);

	boolean deleteBook(Book book);

	List<Book> getAvailableCatalog();

	Book getBookInfo(int id);

	List<Book> getUserBooks(User user);

	boolean updateBook(Book book);

	List<Book> getUserBooksHistory(User user);
}
