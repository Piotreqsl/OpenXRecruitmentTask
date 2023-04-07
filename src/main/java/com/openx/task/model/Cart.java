package com.openx.task.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.openx.task.deserializers.UserDeserializer;
import lombok.*;

import java.util.Date;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Cart {
    private int id;

    @JsonProperty("userId")
    @JsonDeserialize(using = UserDeserializer.class)
    private User user;

    private Date date;
    private List<CartDetail> products;

}
