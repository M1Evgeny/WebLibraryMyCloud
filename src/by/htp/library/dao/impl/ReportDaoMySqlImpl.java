package by.htp.library.dao.impl;

import static by.htp.library.util.DateUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import by.htp.library.dao.ReportDao;
import by.htp.library.model.Report;

public class ReportDaoMySqlImpl extends AbstractDaoMySqlImpl implements ReportDao {

	private static final String SELECT_OVERDUE_BOOKS_INFO = "SELECT books.title, users.login, users.id, orders.check_in_date from orders join users on orders.user_id=users.id join books on orders.book_id=books.id WHERE check_in_date<? AND check_in_date IS NOT NULL";
	private ResultSet rs;

	public List<Report> readAllOverdueBooks() {
		List<Report> catalog = new ArrayList<>();
		try (Connection conn = mySqlConn.getConnection();
				PreparedStatement ps = conn.prepareStatement(SELECT_OVERDUE_BOOKS_INFO)) {
			ps.setString(1, getTodaysDate());
			rs = ps.executeQuery();
			while (rs.next()) {
				catalog.add(buildReport(rs));
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

	private Report buildReport(ResultSet rs) throws SQLException, ParseException {
		Report report = new Report();
		report.setUserId(rs.getInt(REPORT_USER_ID));
		report.setBookTitle(rs.getString(REPORT_BOOK_TITLE));
		report.setUserLogin(rs.getString(REPORT_USER_LOGIN));
		report.setBookReturnDate(rs.getString(REPORT_BOOK_CHECK_IN_DATE));
		setReportReturnDate(report, getPeriod(report.getBookReturnDate()));
		return report;
	}

}
