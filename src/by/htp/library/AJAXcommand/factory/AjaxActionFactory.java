package by.htp.library.AJAXcommand.factory;

import static by.htp.library.util.ControllerConstantPool.*;
import javax.servlet.http.HttpServletRequest;

import by.htp.library.AJAXcommand.AjaxActionCommand;
import by.htp.library.AJAXcommand.client.AjaxCommandEnum;
import by.htp.library.AJAXcommand.impl.EmptyAjaxCommand;

public class AjaxActionFactory {

	public AjaxActionCommand defineCommand(HttpServletRequest request, String action) {
		AjaxActionCommand current = new EmptyAjaxCommand();
		if (action == null || action.isEmpty()) {
			return current;
		}
		try {
			AjaxCommandEnum currentEnum = AjaxCommandEnum.valueOf(action.toUpperCase());
			current = currentEnum.getCurrentAjaxCommand();
		} catch (IllegalArgumentException e) {
			request.setAttribute(WRONG_ACTION, action);
		}
		return current;
	}

}
