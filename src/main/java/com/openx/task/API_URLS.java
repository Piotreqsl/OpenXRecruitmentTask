package com.openx.task;

public enum API_URLS {
    USERS("https://fakestoreapi.com/users"),
    CARTS("https://fakestoreapi.com/carts"),
    PRODUCTS("https://fakestoreapi.com/products");

    private final String url;

    API_URLS(String  url){
        this.url = url;
    }

    public String getUrl(){
        return url;
    }

}
