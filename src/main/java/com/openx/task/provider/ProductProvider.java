package com.openx.task.provider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.openx.task.API_URLS;
import com.openx.task.model.Product;
import com.openx.task.model.User;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ProductProvider {
    public static List<Product> fetchedProducts = new ArrayList<>();
    public static List<Product> getData(){
        try {
            URL url = new URL(API_URLS.PRODUCTS.getUrl());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            InputStream inputStream = connection.getInputStream();
            ObjectMapper objectMapper = new ObjectMapper();
            List<Product> productList = objectMapper.readValue(inputStream, new TypeReference<List<Product>>(){});
            inputStream.close();
            connection.disconnect();
            fetchedProducts = productList;
            return productList;
        }
        catch (IOException e){
            e.printStackTrace();
            return new ArrayList<Product>();
        }

    }
}
