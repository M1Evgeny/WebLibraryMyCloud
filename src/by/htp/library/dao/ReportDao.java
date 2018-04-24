package by.htp.library.dao;

import java.util.List;

import by.htp.library.model.Report;

public interface ReportDao {
	List<Report> readAllOverdueBooks();
}
