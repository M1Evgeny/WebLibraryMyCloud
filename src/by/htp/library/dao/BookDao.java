package by.htp.library.dao;

import java.util.List;

import by.htp.library.model.Book;
import by.htp.library.model.User;

public interface BookDao extends BaseDao<Book> {
	boolean create(Book book);

	List<Book> readAll();

	List<Book> readUncheckedBooks();

	List<Book> readUserBooks(User user);

	List<Book> readUserBooksHistory(User user);

	List<Book> readOverdueUserBooks(User user);

	void checkOutBookQuantity(Book book);

	boolean checkOutBook(User user, Book book);

	void checkInBookQuantity(Book book);

	boolean checkInBook(User user, Book book);
}
