package by.htp.library.AJAXcommand.impl;

import static by.htp.library.util.ControllerConstantPool.*;
import javax.servlet.http.HttpServletRequest;
import com.google.gson.Gson;
import by.htp.library.AJAXcommand.AjaxActionCommand;

public class AddBook implements AjaxActionCommand {

	@Override
	public String execute(HttpServletRequest request) {

		return new Gson().toJson(PAGE_ADD_BOOK);
	}

}
