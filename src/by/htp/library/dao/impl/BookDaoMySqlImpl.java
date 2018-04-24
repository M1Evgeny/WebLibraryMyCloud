package by.htp.library.dao.impl;

import static by.htp.library.util.DateUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import by.htp.library.dao.BookDao;
import by.htp.library.model.Book;
import by.htp.library.model.User;

public class BookDaoMySqlImpl extends AbstractDaoMySqlImpl implements BookDao {

	private static final String INSERT_INTO_BOOKS = "INSERT INTO books(Title, Author, Year) VALUES (?, ?, ?)";
	private static final String SELECT_BOOK = "SELECT id, Title, Author, Year FROM books WHERE id = ?";
	private static final String SELECT_OVERDUE_BOOKS = "SELECT books.id, books.Title, books.Author, books.year, orders.check_in_date FROM orders JOIN books ON orders.book_id=books.id WHERE check_in_date<? and user_id=?";
	private static final String SELECT_USER_BOOK_HISTORY = "SELECT books.id, books.title, books.author, books.year from orders join books on orders.book_id=books.id WHERE user_id=? AND status='unchecked'";
	private static final String SELECT_USER_BOOK = "SELECT books.id, books.title, books.author, books.year, orders.check_in_date from orders join books on orders.book_id=books.id WHERE user_id=? AND status='checked' AND check_in_date IS NOT NULL";
	private static final String UPDATE_BOOKS = "UPDATE books SET Title=?, Author=?, Year=? WHERE id=?";
	private static final String UPDATE_BOOKS_CHECK_OUT = "UPDATE books SET quantity=quantity-1 WHERE id=?";
	private static final String UPDATE_BOOKS_CHECK_IN = "UPDATE books SET quantity=quantity+1 WHERE id=?";
	private static final String DELETE_BOOKS = "DELETE FROM books WHERE id = ?";
	private static final String SELECT_ALL_BOOKS = "SELECT id, Title, Author, Year FROM books";
	private static final String SELECT_ALL_AVAILABLE_BOOKS = "SELECT id, Title, Author, Year FROM books WHERE quantity>'0'";
	private static final String CHECK_OUT_BOOK = "INSERT orders SET user_id=?, book_id=?, status=?, check_in_date=?";
	private static final String CHECK_IN_BOOK = "UPDATE orders SET status=?, check_in_date=? WHERE user_id=? AND book_id=?";

	@Override
	public Book read(int id) {
		Book book = null;
		ResultSet rs = null;
		try (Connection conn = mySqlConn.getConnection(); PreparedStatement ps = conn.prepareStatement(SELECT_BOOK);) {
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				book = buildBook(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return book;
	}

	@Override
	public boolean update(Book book) {
		boolean result = false;
		try (Connection conn = mySqlConn.getConnection(); PreparedStatement ps = conn.prepareStatement(UPDATE_BOOKS)) {
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getAuthor());
			ps.setInt(3, book.getYear());
			ps.setInt(4, book.getId());
			ps.executeUpdate();
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean delete(Book book) {
		boolean result = false;
		ResultSet rs = null;
		try (Connection conn = mySqlConn.getConnection(); PreparedStatement ps = conn.prepareStatement(DELETE_BOOKS)) {
			ps.setInt(1, book.getId());
			ps.executeUpdate();
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return result;
	}

	@Override
	public boolean create(Book book) {
		boolean result = false;
		try (Connection conn = mySqlConn.getConnection();
				PreparedStatement st = conn.prepareStatement(INSERT_INTO_BOOKS)) {
			st.setString(1, book.getTitle());
			st.setString(2, book.getAuthor());
			st.setInt(3, book.getYear());
			st.executeUpdate();
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Book> readAll() {
		List<Book> catalog = new ArrayList<>();
		try (Connection conn = mySqlConn.getConnection();
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(SELECT_ALL_BOOKS)) {
			while (rs.next()) {
				catalog.add(buildBook(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return catalog;
	}

	public List<Book> readUncheckedBooks() {
		List<Book> catalog = new ArrayList<>();
		try (Connection conn = mySqlConn.getConnection();
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(SELECT_ALL_AVAILABLE_BOOKS)) {
			while (rs.next()) {
				catalog.add(buildBook(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return catalog;
	}

	public List<Book> readUserBooks(User user) {
		List<Book> catalog = new ArrayList<>();
		try (Connection conn = mySqlConn.getConnection();
				PreparedStatement ps = conn.prepareStatement(SELECT_USER_BOOK)) {
			ps.setInt(1, user.getId());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				catalog.add(buildUserBook(rs));
			}
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		}
		return catalog;
	}

	public List<Book> readUserBooksHistory(User user) {
		List<Book> catalog = new ArrayList<>();
		try (Connection conn = mySqlConn.getConnection();
				PreparedStatement ps = conn.prepareStatement(SELECT_USER_BOOK_HISTORY)) {
			ps.setInt(1, user.getId());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				catalog.add(buildBook(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return catalog;
	}

	public List<Book> readOverdueUserBooks(User user) {
		List<Book> catalog = new ArrayList<>();
		ResultSet rs = null;
		try (Connection conn = mySqlConn.getConnection();
				PreparedStatement ps = conn.prepareStatement(SELECT_OVERDUE_BOOKS)) {
			ps.setString(1, getTodaysDate());
			ps.setInt(2, user.getId());
			rs = ps.executeQuery();
			while (rs.next()) {
				catalog.add(buildUserBook(rs));
			}
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return catalog;
	}

	public boolean checkOutBook(User user, Book book) {
		boolean result = false;
		try (Connection conn = mySqlConn.getConnection();
				PreparedStatement ps = conn.prepareStatement(CHECK_OUT_BOOK)) {
			ps.setInt(1, user.getId());
			ps.setInt(2, book.getId());
			ps.setString(3, BOOK_STATUS_CHECKED);
			ps.setString(4, dateIncrementer(getTodaysDate()));
			ps.executeUpdate();
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public boolean checkInBook(User user, Book book) {
		boolean result = false;
		try (Connection conn = mySqlConn.getConnection(); PreparedStatement st = conn.prepareStatement(CHECK_IN_BOOK)) {
			st.setString(1, BOOK_STATUS_UNCHECKED);
			st.setString(2, null);
			st.setInt(3, user.getId());
			st.setInt(4, book.getId());
			st.executeUpdate();
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public void checkOutBookQuantity(Book book) {
		try (Connection conn = mySqlConn.getConnection();
				PreparedStatement ps = conn.prepareStatement(UPDATE_BOOKS_CHECK_OUT)) {
			ps.setInt(1, book.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void checkInBookQuantity(Book book) {
		try (Connection conn = mySqlConn.getConnection();
				PreparedStatement ps = conn.prepareStatement(UPDATE_BOOKS_CHECK_IN)) {
			ps.setInt(1, book.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private Book buildBook(ResultSet rs) throws SQLException {
		Book book = new Book();
		book.setId(rs.getInt(BOOK_ID));
		book.setTitle(rs.getString(BOOK_TITLE));
		book.setAuthor(rs.getString(BOOK_AUTHOR));
		book.setYear(rs.getInt(BOOK_PUBLISH_YEAR));
		return book;
	}

	private Book buildUserBook(ResultSet rs) throws SQLException, ParseException {
		Book book = new Book();
		book.setId(rs.getInt(BOOK_ID));
		book.setTitle(rs.getString(BOOK_TITLE));
		book.setAuthor(rs.getString(BOOK_AUTHOR));
		book.setYear(rs.getInt(BOOK_PUBLISH_YEAR));
		book.setReturnDate(rs.getString(BOOK_CHECK_IN_DATE));
		setBookReturnDate(book, getPeriod(book.getReturnDate()));
		return book;
	}

}
