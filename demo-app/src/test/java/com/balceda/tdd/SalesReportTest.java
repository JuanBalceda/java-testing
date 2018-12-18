package com.balceda.tdd;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class SalesReportTest {

    @Test
    public void ShouldPrintSotreReportForSampleData() {
	ApplicationRunner runner = new ApplicationRunner();

	String report = runner.run("src/main/resources/example-sales.csv");

	assertThat(report, containsString("- London          -    235 -"));
    }
}
