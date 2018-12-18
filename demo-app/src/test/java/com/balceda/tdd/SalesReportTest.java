package com.balceda.tdd;

import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.balceda.tdd.app.SalesReport;
import com.balceda.tdd.service.SalesAnalyser;

public class SalesReportTest {

    private static final String CITY = "London";
    private static final int TALLY = 235; 
    
    private PrintStream mockout = mock(PrintStream.class);
    private SalesAnalyser mockanalyser = mock(SalesAnalyser.class);
    private SalesReport reporte = new SalesReport(mockanalyser, mockout);
    
    @Test
    public void shouldPrintCityTallies(){
	Map<String, Integer> cityTallies = new HashMap<>();
	cityTallies.put(CITY, TALLY);
	when(mockanalyser.tallyCitySales()).thenReturn(cityTallies);
	
	reporte.run();
	
	verify(mockout).printf(anyString(), eq(CITY), eq(TALLY));
    }
}
