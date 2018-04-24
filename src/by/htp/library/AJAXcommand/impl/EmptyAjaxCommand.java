package by.htp.library.AJAXcommand.impl;

import javax.servlet.http.HttpServletRequest;

import by.htp.library.AJAXcommand.AjaxActionCommand;

public class EmptyAjaxCommand implements AjaxActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		return "EmptyAjaxCommand - something went wrong";
	}

}
