package com.openx.task.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Address {

    @JsonProperty("zipcode")
    private String zipcode;
    @JsonProperty("number")
    private Integer number;
    @JsonProperty("street")
    private String street;
    @JsonProperty("city")
    private String city;

    @JsonProperty("geolocation")
    private Geolocation geolocation;


}
