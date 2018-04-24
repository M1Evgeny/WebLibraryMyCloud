package by.htp.library.AJAXcommand.client;

import by.htp.library.AJAXcommand.AjaxActionCommand;
import by.htp.library.AJAXcommand.impl.AddBook;
import by.htp.library.AJAXcommand.impl.AddBookInfo;
import by.htp.library.AJAXcommand.impl.CheckInBook;
import by.htp.library.AJAXcommand.impl.CheckOutBook;
import by.htp.library.AJAXcommand.impl.CheckUserNameAjaxCommand;
import by.htp.library.AJAXcommand.impl.DeleteBook;
import by.htp.library.AJAXcommand.impl.GetAvailableBooks;
import by.htp.library.AJAXcommand.impl.GetBookCatalog;
import by.htp.library.AJAXcommand.impl.GetBookInfo;
import by.htp.library.AJAXcommand.impl.GetMyBooks;
import by.htp.library.AJAXcommand.impl.GetUserInfo;
import by.htp.library.AJAXcommand.impl.GetUsersList;
import by.htp.library.AJAXcommand.impl.OverdueBooks;
import by.htp.library.AJAXcommand.impl.UpdateBook;
import by.htp.library.AJAXcommand.impl.UpdateBookInfo;
import by.htp.library.AJAXcommand.impl.UserBooksHistory;
import by.htp.library.AJAXcommand.impl.UserProfile;

public enum AjaxCommandEnum {
	USERNAME {
		{
			this.ajaxCommand = new CheckUserNameAjaxCommand();
		}
	},
	USERS {
		{
			this.ajaxCommand = new GetUsersList();
		}
	},
	INFOUSER {
		{
			this.ajaxCommand = new GetUserInfo();
		}
	},
	BOOKS {
		{
			this.ajaxCommand = new GetBookCatalog();
		}
	},
	INFOBOOK {
		{
			this.ajaxCommand = new GetBookInfo();
		}
	},
	ADDBOOK {
		{
			this.ajaxCommand = new AddBook();
		}
	},
	ADDBOOKINFO {
		{
			this.ajaxCommand = new AddBookInfo();
		}
	},
	DELETEBOOK {
		{
			this.ajaxCommand = new DeleteBook();
		}
	},
	UPDATEBOOK {
		{
			this.ajaxCommand = new UpdateBook();
		}
	},
	UPDATEBOOKINFO {
		{
			this.ajaxCommand = new UpdateBookInfo();
		}
	},
	PROFILE {
		{
			this.ajaxCommand = new UserProfile();
		}
	},
	CHECKOUT {
		{
			this.ajaxCommand = new CheckOutBook();
		}
	},
	AVAILABLEBOOKS {
		{
			this.ajaxCommand = new GetAvailableBooks();
		}
	},
	MYBOOKS{
		{
			this.ajaxCommand = new GetMyBooks();
		}
	},
	CHECKIN{
		{
			this.ajaxCommand = new CheckInBook();
		}
	},
	OVERDUE{
		{
			this.ajaxCommand = new OverdueBooks();
		}
	},
	HISTORY{
		{
			this.ajaxCommand = new UserBooksHistory();
		}
	};

	AjaxActionCommand ajaxCommand;

	public AjaxActionCommand getCurrentAjaxCommand() {
		return ajaxCommand;
	}
}
