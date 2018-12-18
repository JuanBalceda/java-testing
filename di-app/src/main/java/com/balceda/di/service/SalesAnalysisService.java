package com.balceda.di.service;

import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.balceda.di.model.Sale;
import com.balceda.di.repository.interfaces.SalesRepository;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

@Component
public class SalesAnalysisService {

    private final SalesRepository repository;
    
    @Autowired
    public SalesAnalysisService(SalesRepository repo) {
        this.repository = repo;
    }

    public Map<String, Integer> tallyProductSales() {
        return tallySalesBy(Sale::getProduct);
    }

    public Map<String, Integer> tallyStoreSales() {
        return tallySalesBy(Sale::getStore);
    }

    private Map<String, Integer> tallySalesBy(Function<Sale, String> classifier) {
        return repository.loadSales()
                   .stream()
                   .collect(groupingBy(classifier,
                                summingInt(Sale::getValue)));
    }

}
