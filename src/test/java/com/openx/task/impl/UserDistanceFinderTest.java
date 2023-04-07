package com.openx.task.impl;

import com.openx.task.model.Address;
import com.openx.task.model.Geolocation;
import com.openx.task.model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDistanceFinderTest {

    static private User user1;
    static private User user2;
    static private User user3;
    static private User user4;
    static private User user5;


    @BeforeAll
    static void setUp() {
        Address address1  = new Address();
        Geolocation london = new Geolocation((float) 51.507351, (float) -0.127758);
        user1 = new User();
        address1.setGeolocation(london);
        user1.setAddress(address1);

        Address address2 = new Address();
        Geolocation leeds = new Geolocation((float) 53.800755, (float) -1.549077);
         user2 = new User();
        address2.setGeolocation(leeds);
        user2.setAddress(address2);

        Address address3 = new Address();
        Geolocation manchaster = new Geolocation((float) 53.480709, (float) -2.234380);
         user3 = new User();
        address3.setGeolocation(manchaster);
        user3.setAddress(address3);

        Address address4 = new Address();
        Geolocation tingley = new Geolocation((float) 53.730511, (float) -1.570670);
         user4 = new User();
        address4.setGeolocation(tingley);
        user4.setAddress(address4);

        Address address5 = new Address();
        Geolocation warsaw = new Geolocation((float) 52.237049, (float) 21.017532);
         user5 = new User();
        address5.setGeolocation(warsaw);
        user5.setAddress(address5);



    }

    @Test
    void shouldReturnSameListWhenOnly2ArgsGiven() {
        //given
        List<User> test = List.of(user1, user2);

        //when
        List<User> res = UserDistanceFinder.getMostFarAwayUsers(test);

        //then
        assertEquals(res, test);
    }

    @Test
    void shouldReturnFarthestUsers() {
        //given
        List<User> test = List.of(user1, user2,user3,user4,user5);

        //when
        List<User> res = UserDistanceFinder.getMostFarAwayUsers(test);

        //then
        assertEquals(res, List.of(user3, user5)); // leeds - warsaw
    }


}