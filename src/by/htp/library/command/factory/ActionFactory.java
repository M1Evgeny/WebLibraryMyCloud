package by.htp.library.command.factory;

import static by.htp.library.util.ControllerConstantPool.*;
import javax.servlet.http.HttpServletRequest;

import by.htp.library.command.ActionCommand;
import by.htp.library.command.client.CommandEnum;
import by.htp.library.command.impl.EmptyCommand;

public class ActionFactory {

	public ActionCommand defineCommand(HttpServletRequest request, String action) {
		ActionCommand current = new EmptyCommand();
		if (action == null || action.isEmpty()) {
			return current;
		}
		try {
			CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
			current = currentEnum.getCurrentCommand();
		} catch (IllegalArgumentException e) {
			request.setAttribute(WRONG_ACTION, action);
		}
		return current;
	}
}
