package by.htp.library.command.impl;

import static by.htp.library.util.ControllerConstantPool.*;
import javax.servlet.http.HttpServletRequest;

import by.htp.library.command.ActionCommand;

public class LogoutCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		request.getSession().invalidate();
		return PAGE_INDEX;
	}

}
