package com.openx.task.impl;

import com.openx.task.model.User;
import com.openx.task.utils.GeographyHelper;

import java.util.List;

public class UserDistanceFinder {

    public static List<User> getMostFarAwayUsers(List<User> users){
        User fav1 = new User();
        User fav2 = new User();
        float bestDistance = 0;


        /// i know its n^2 but user data is pretty small, so there is no need to make it better.
        for(int i = 0; i < users.size(); i++){
            for(int j = i+1; j < users.size(); j++){
                User tmp1 = users.get(i);
                User tmp2 = users.get(j);

                float distance = GeographyHelper.distFrom(tmp1.getAddress().getGeolocation().getLatitude(),tmp1.getAddress().getGeolocation().getLongitude(), tmp2.getAddress().getGeolocation().getLatitude(), tmp2.getAddress().getGeolocation().getLongitude());
                if(distance > bestDistance) {
                    fav1 = tmp1;
                    fav2 = tmp2;
                    bestDistance = distance;
                }
            }
        }

        return List.of(fav1, fav2);
    }
}
