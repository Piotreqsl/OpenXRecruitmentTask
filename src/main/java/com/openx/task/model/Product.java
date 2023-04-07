package com.openx.task.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Product {
    private int id;
    private String title;
    private String description;
    private String category;
    private String image;
    private double price;
    private Rating rating;

}


