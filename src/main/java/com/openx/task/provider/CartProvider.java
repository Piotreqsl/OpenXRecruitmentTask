package com.openx.task.provider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.openx.task.model.Cart;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class CartProvider {


    public static List<Cart> getData(){
        try {
            // Read JSON data from file into a String object
            InputStream inputStream = CartProvider.class.getResourceAsStream("/cart.json");
            ObjectMapper objectMapper = new ObjectMapper();
            List<Cart> cartList = objectMapper.readValue(inputStream, new TypeReference<List<Cart>>(){});
            inputStream.close();
            return cartList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<Cart>();
    }
}
