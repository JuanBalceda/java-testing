package com.balceda.di.app;

import java.io.PrintStream;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.balceda.di.repository.impl.CsvSalesRepository;
import com.balceda.di.service.SalesAnalysisService;

public class SpringReportRunner {

    private static String fileLocation;

    public static void main(String[] args) {

	if (args.length < 1) {
	    System.err.println("You must provide a commandline argument specifying the file to analyse");
	    System.exit(-1);
	}

	fileLocation = args[0];
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

	SalesReport report = context.getBean(SalesReport.class);
	report.report();
    }

    public static String getFileLocation() {
	return fileLocation;
    }

    public static PrintStream getOutput() {
	return System.err;
    }

}
