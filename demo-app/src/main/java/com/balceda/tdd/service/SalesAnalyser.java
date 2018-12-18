package com.balceda.tdd.service;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

import java.util.Map;

import com.balceda.tdd.model.Sale;
import com.balceda.tdd.repository.SalesRepository;

public class SalesAnalyser {

    private final SalesRepository repository;
    
    public SalesAnalyser(SalesRepository repo) {
        this.repository = repo;
    }

    public Map<String, Integer> tallyCitySales() {
        return repository.loadSales()
                   .stream()
                   .collect(groupingBy(Sale::getStore,
                                summingInt(Sale::getValue)));
    }

}
