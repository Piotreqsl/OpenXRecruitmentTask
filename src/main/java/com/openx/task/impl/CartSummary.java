package com.openx.task.impl;

import com.openx.task.model.Cart;
import com.openx.task.model.CartDetail;
import com.openx.task.model.Product;
import com.openx.task.model.User;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CartSummary {

    public static Cart getTopValue(List<Cart> carts){
        List<Cart> sorted = carts.stream().sorted((o1, o2) -> {
            double val1, val2;
            val1 = o1.getProducts().stream().map(prod -> prod.getProduct().getPrice() * prod.getQuantity()).mapToDouble(Double::doubleValue).sum();
            val2 = o2.getProducts().stream().map(prod -> prod.getProduct().getPrice() * prod.getQuantity()).mapToDouble(Double::doubleValue).sum();
            if(val1 > val2) return -1;
            else if (val2 == val1) return 0;
            return 1;
        }).toList();
        return sorted.get(0);

    }
}
