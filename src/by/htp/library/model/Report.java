package by.htp.library.model;

public class Report extends BaseEntity {
	private String bookTitle;
	private String bookReturnDate;
	private String userLogin;
	private int userId;

	public Report() {
		super();
	}

	public Report(String bookTitle, String bookReturnDate, String userLogin, int userId) {
		super();
		this.bookTitle = bookTitle;
		this.bookReturnDate = bookReturnDate;
		this.userLogin = userLogin;
		this.userId = userId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookReturnDate() {
		return bookReturnDate;
	}

	public void setBookReturnDate(String bookReturnDate) {
		this.bookReturnDate = bookReturnDate;
	}

	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookReturnDate == null) ? 0 : bookReturnDate.hashCode());
		result = prime * result + ((bookTitle == null) ? 0 : bookTitle.hashCode());
		result = prime * result + userId;
		result = prime * result + ((userLogin == null) ? 0 : userLogin.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Report other = (Report) obj;
		if (bookReturnDate == null) {
			if (other.bookReturnDate != null)
				return false;
		} else if (!bookReturnDate.equals(other.bookReturnDate))
			return false;
		if (bookTitle == null) {
			if (other.bookTitle != null)
				return false;
		} else if (!bookTitle.equals(other.bookTitle))
			return false;
		if (userId != other.userId)
			return false;
		if (userLogin == null) {
			if (other.userLogin != null)
				return false;
		} else if (!userLogin.equals(other.userLogin))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Report [bookTitle=" + bookTitle + ", bookReturnDate=" + bookReturnDate + ", userLogin=" + userLogin
				+ ", userId=" + userId + "]";
	}

}
