package com.openx.task.provider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.openx.task.API_URLS;
import com.openx.task.model.User;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class UserProvider {

    public static List<User> fetchedUsers = new ArrayList<>();

    public static List<User> getData(){
        try {
            URL url = new URL(API_URLS.USERS.getUrl());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            InputStream inputStream = connection.getInputStream();
            ObjectMapper objectMapper = new ObjectMapper();
            List<User> userList = objectMapper.readValue(inputStream, new TypeReference<List<User>>(){});
            inputStream.close();
            connection.disconnect();
            fetchedUsers = userList;
            return userList;
        }
        catch (IOException e){
            e.printStackTrace();
            return new ArrayList<User>();
        }

    }

}
