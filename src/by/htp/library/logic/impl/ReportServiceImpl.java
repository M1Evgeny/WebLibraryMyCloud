package by.htp.library.logic.impl;

import java.util.List;

import by.htp.library.dao.ReportDao;
import by.htp.library.dao.impl.ReportDaoMySqlImpl;
import by.htp.library.logic.ReportService;
import by.htp.library.model.Report;

public class ReportServiceImpl implements ReportService{
	ReportDao report = new ReportDaoMySqlImpl();

	@Override
	public List<Report> getAllOverdueBooks() {
		return report.readAllOverdueBooks();
	}

}
