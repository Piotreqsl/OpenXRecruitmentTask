package com.openx.task.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;


@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class User {

    private Address address;
    private Name name;
    private int id;
    private String email;
    private String username;
    private String password;
    private String phone;




}
