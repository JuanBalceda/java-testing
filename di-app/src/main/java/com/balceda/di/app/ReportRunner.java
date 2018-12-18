package com.balceda.di.app;

import com.balceda.di.repository.impl.CsvSalesRepository;
import com.balceda.di.service.SalesAnalysisService;

public class ReportRunner {

    public static void main(String[] args) {

	if (args.length < 1) {
	    System.err.println("You must provide a commandline argument specifying the file to analyse");
	    System.exit(-1);
	}

	CsvSalesRepository repository = new CsvSalesRepository(args[0]);
	repository.setError(System.err);
	
	SalesAnalysisService analyser = new SalesAnalysisService(repository);
	SalesReport report = new SalesReport(System.out, analyser);
	report.report();
    }

}
