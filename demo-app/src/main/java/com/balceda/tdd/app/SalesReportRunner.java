package com.balceda.tdd.app;

import java.io.PrintStream;

import com.balceda.tdd.repository.SalesRepository;
import com.balceda.tdd.service.SalesAnalyser;

public class SalesReportRunner {
    
    private PrintStream out;

    public SalesReportRunner(final PrintStream out) {
	this.out = out;
    }

    public static void main(String[] args) {
	String fileLocation = args[0];
	
	new SalesReportRunner(System.out).run(fileLocation);
    }
    
    public void run(final String fileLocation){
	SalesRepository repo = new SalesRepository(fileLocation);
	SalesAnalyser analyser = new SalesAnalyser(repo);
	SalesReport report = new SalesReport(analyser, out);
	report.run();
    }
}
