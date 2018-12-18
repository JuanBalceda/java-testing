package com.balceda.tdd;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import com.balceda.tdd.app.SalesReportRunner;

public class ApplicationRunner {

    public String run(String inputFile) {
	ByteArrayOutputStream dummyOutput = new ByteArrayOutputStream();
	SalesReportRunner app = new SalesReportRunner(new PrintStream(dummyOutput));
	app.run(inputFile);
	try {
	    return dummyOutput.toString("UTF-8");
	} catch (UnsupportedEncodingException e) {
	    throw new RuntimeException(e);
	}
    }

    
}
