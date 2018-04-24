package by.htp.library.AJAXcommand.impl;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

import by.htp.library.AJAXcommand.AjaxActionCommand;
import by.htp.library.logic.ReportService;
import by.htp.library.logic.impl.ReportServiceImpl;

public class OverdueBooks implements AjaxActionCommand {
	ReportService reportService = new ReportServiceImpl();

	@Override
	public String execute(HttpServletRequest request) {
		return new Gson().toJson(reportService.getAllOverdueBooks());
	}

}
