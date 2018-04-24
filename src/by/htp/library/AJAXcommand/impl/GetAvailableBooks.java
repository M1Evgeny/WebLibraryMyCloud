package by.htp.library.AJAXcommand.impl;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

import by.htp.library.AJAXcommand.AjaxActionCommand;
import by.htp.library.logic.BookService;
import by.htp.library.logic.impl.BookServiceImpl;

public class GetAvailableBooks implements AjaxActionCommand {

	BookService service = new BookServiceImpl();

	@Override
	public String execute(HttpServletRequest request) {
		return new Gson().toJson(service.getAvailableCatalog());
	}

}
