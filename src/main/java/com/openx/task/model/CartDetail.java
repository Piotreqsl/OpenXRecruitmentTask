package com.openx.task.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.openx.task.deserializers.ProductDeserializer;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
@Setter
public class CartDetail {
    @JsonProperty("productId")
    @JsonDeserialize(using = ProductDeserializer.class)
    private Product product;
    private int quantity;
}
