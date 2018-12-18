package com.balceda.di.repository.interfaces;

import java.util.List;

import com.balceda.di.model.Sale;

public interface SalesRepository {

    public List<Sale> loadSales();

}
