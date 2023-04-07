package com.openx.task.impl;

import com.openx.task.model.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CartSummaryTest {

    static private User user1;
    static private Product product1;
    static private Product product2;
    static private Product product3;

    static private Cart cart1;
    static private Cart cart2;
    static private Cart cart3;


    @BeforeAll
    static void setUp() {
        Address address1  = new Address();
        Geolocation london = new Geolocation((float) 51.507351, (float) -0.127758);
        user1 = new User();
        address1.setGeolocation(london);
        user1.setAddress(address1);
        user1.setName(new Name("Piotr", "Skipper"));

        product1 = new Product();
        product1.setId(1);
        product1.setPrice(250);

        product2 = new Product();
        product2.setId(2);
        product2.setPrice(20);

        product3 = new Product();
        product3.setId(2);
        product3.setPrice(60);

        cart1 = new Cart();
        cart1.setId(1);
        cart1.setUser(user1);
        List<CartDetail> details = List.of(new CartDetail(product1, 1), new CartDetail(product2,4)); //320 total
        cart1.setProducts(details);

        cart2 = new Cart();
        cart2.setId(2);
        cart2.setUser(user1);
        List<CartDetail> details2 = List.of(new CartDetail(product1, 3), new CartDetail(product3,1)); //810 total
        cart2.setProducts(details2);


        cart3 = new Cart();
        cart3.setId(3);
        cart3.setUser(user1);
        List<CartDetail> details3 = List.of(new CartDetail(product2, 3), new CartDetail(product3,1)); //120 total
        cart3.setProducts(details3);





    }


    @Test
    void shouldReturnCartWithHighestVal() {
        List<Cart> carts = List.of(cart1,cart2,cart3);

        Cart highestValCart = CartSummary.getTopValue(carts);

        assertEquals(highestValCart, cart2);
    }
}