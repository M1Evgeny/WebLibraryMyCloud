package by.htp.library.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import by.htp.library.model.Book;
import by.htp.library.model.Report;



public class DateUtil {

	private static final double E = 1.15740740740741E-08;
	private static final int DAY_INCREASE = 10;
	private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	private DateUtil() {
		super();
	}

	public static String getTodaysDate() {
		Date date = new Date();
		return dateFormat.format(date);
	}

	public static String dateIncrementer(String date) {
		return LocalDate.parse(date).plusDays(DAY_INCREASE).toString();
	}

	public static int getPeriod(String checkInDate) throws ParseException {
		Date todaysDate = dateFormat.parse(getTodaysDate());
		Date returnDate = dateFormat.parse(checkInDate);
		long milliseconds = returnDate.getTime() - todaysDate.getTime();
		return (int) (milliseconds * E);
	}

	public static void setReportReturnDate(Report report, int days) {
		if (days < 0) {
			report.setBookReturnDate(overdue(days));
		}
	}

	public static void setBookReturnDate(Book book, int days) {
		if (days < 0) {
			book.setReturnDate(overdue(days));
		}
	}

	public static String overdue(int days) {
		return String.format("%s days ago", Integer.toString(days * (-1)));
	}

}
