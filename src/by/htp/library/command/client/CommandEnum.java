package by.htp.library.command.client;

import by.htp.library.command.ActionCommand;
import by.htp.library.command.impl.CheckOverdueBooksCommand;
import by.htp.library.command.impl.LoginCommand;
import by.htp.library.command.impl.LogoutCommand;
import by.htp.library.command.impl.SignUpCommand;

public enum CommandEnum {
	LOGIN {
		{
			this.command = new LoginCommand();
		}
	},
	LOGOUT {
		{
			this.command = new LogoutCommand();
		}
	},
	SINGUP {
		{
			this.command = new SignUpCommand();
		}
	},
	RETURNBOOK{
		{
			this.command = new CheckOverdueBooksCommand();
		}
	};

	ActionCommand command;

	public ActionCommand getCurrentCommand() {
		return command;
	}
}
