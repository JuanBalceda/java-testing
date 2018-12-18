package com.balceda.tdd;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import com.balceda.tdd.model.Sale;
import com.balceda.tdd.repository.SalesRepository;

public class SalesRepositoryTest {

    @Test
    public void shouldLoadSampleData() {
	SalesRepository repo = new SalesRepository("src/main/resources/example-sales.csv");
	List<Sale> sales = repo.loadSales();

	assertThat(sales, hasItem(allOf(
		hasProperty("store", equalTo("London")),
		hasProperty("number", equalTo(2)),
		hasProperty("pricePerItem", equalTo(30))
	)));
    }
}
