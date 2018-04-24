package by.htp.library.dao.impl;

import by.htp.library.dao.util.MySqlConnection;

public class AbstractDaoMySqlImpl {

	protected static final String USER_ID = "id";
	protected static final String USER_LOGIN = "login";
	protected static final String USER_PASS = "password";
	protected static final String USER_ROLE = "role";

	protected static final String BOOK_STATUS_CHECKED = "checked";
	protected static final String BOOK_STATUS_UNCHECKED = "unchecked";
	protected static final String BOOK_ID = "id";
	protected static final String BOOK_TITLE = "title";
	protected static final String BOOK_AUTHOR = "author";
	protected static final String BOOK_PUBLISH_YEAR = "year";
	protected static final String BOOK_CHECK_IN_DATE = "check_in_date";

	protected static final String REPORT_USER_ID = "id";
	protected static final String REPORT_BOOK_TITLE = "title";
	protected static final String REPORT_USER_LOGIN = "login";
	protected static final String REPORT_BOOK_CHECK_IN_DATE = "check_in_date";

	MySqlConnection mySqlConn;

	{
		mySqlConn = new MySqlConnection();
	}

}
