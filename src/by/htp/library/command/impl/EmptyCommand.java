package by.htp.library.command.impl;

import javax.servlet.http.HttpServletRequest;

import by.htp.library.command.ActionCommand;
import static by.htp.library.util.ControllerConstantPool.*;

public class EmptyCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {

		return PAGE_INDEX;
	}

}
