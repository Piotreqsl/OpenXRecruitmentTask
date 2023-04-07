package com.openx.task.impl;

import com.openx.task.model.Product;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CategorySummary {

    public static Map<String, Double> getSummary(List<Product> products){

        return products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.summingDouble(Product::getPrice)));

    }
}
