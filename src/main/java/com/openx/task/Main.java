package com.openx.task;


import com.openx.task.impl.CartSummary;
import com.openx.task.impl.CategorySummary;
import com.openx.task.impl.UserDistanceFinder;
import com.openx.task.model.Cart;
import com.openx.task.model.Product;
import com.openx.task.model.User;
import com.openx.task.provider.CartProvider;
import com.openx.task.provider.ProductProvider;
import com.openx.task.provider.UserProvider;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        System.out.println("TASK NUMBER ONE");
        ArrayList<User> users = (ArrayList<User>) UserProvider.getData();
        ArrayList<Product> products = (ArrayList<Product>) ProductProvider.getData();
        ArrayList<Cart> carts = (ArrayList<Cart>) CartProvider.getData();



        System.out.println("TASK NUMBER TWO");
        Map<String, Double> categoryPrice = CategorySummary.getSummary(products);
        System.out.println(categoryPrice);

        System.out.println("TASK NUMBER THREE");
        Cart highestValCart = CartSummary.getTopValue(carts);
        System.out.println("highest value cart is owned by user " + highestValCart.getUser().getName() + " and its value is " + highestValCart.getProducts().stream().map(prod -> prod.getProduct().getPrice() * prod.getQuantity()).mapToDouble(Double::doubleValue).sum());

        System.out.println("TASK NUMBER FOUR");
        List<User> topTwo = UserDistanceFinder.getMostFarAwayUsers(users);
        System.out.println(topTwo.get(0).getAddress().getGeolocation());
        System.out.println(topTwo.get(1).getAddress().getGeolocation());


    }
}