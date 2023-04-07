package com.openx.task.deserializers;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.openx.task.model.Product;
import com.openx.task.model.User;
import com.openx.task.provider.ProductProvider;
import com.openx.task.provider.UserProvider;

import java.io.IOException;

public class ProductDeserializer extends StdDeserializer<Product> {
    public ProductDeserializer() {
        this(null);
    }

    public ProductDeserializer(Class<?> vc) {
        super(vc);
    }
    @Override
    public Product deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JacksonException {
        JsonNode node = jp.getCodec().readTree(jp);
        int id = node.asInt();
        return getProductById(id);

    }


    private Product getProductById(int productId) throws JsonProcessingException {

        for (Product product : ProductProvider.fetchedProducts) {
            if (product.getId() == productId) {
                return product;
            }
        }
        throw new IllegalArgumentException("User with ID " + productId + " not found");
    }
}
