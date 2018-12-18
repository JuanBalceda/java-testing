package com.balceda.tdd.repository;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.balceda.tdd.model.Sale;

import au.com.bytecode.opencsv.CSVReader;

public class SalesRepository {

    private final String fileLocation;
    private List<Sale> sales;

    public SalesRepository(String fileLocation) {
	this.fileLocation = fileLocation;
    }

    public List<Sale> loadSales() {
	if (sales == null) {
	    sales = new ArrayList<>();
	    try (CSVReader reader = new CSVReader(new FileReader(fileLocation))) {
		String[] nextLine;
		while ((nextLine = reader.readNext()) != null) {
		    String product = nextLine[0].trim();
		    String store = nextLine[1].trim();
		    int number = parseInt(nextLine[2]);
		    int pricePerItem = parseInt(nextLine[3]);
		    sales.add(new Sale(product, store, number, pricePerItem));
		}
		return sales;
	    } catch (IOException e) {
		e.printStackTrace();
		return null;
	    }
	}
	return sales;
    }

    private int parseInt(String value) {
	return Integer.parseInt(value.trim());
    }

}
