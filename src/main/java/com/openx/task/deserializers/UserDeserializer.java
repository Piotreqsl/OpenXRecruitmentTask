package com.openx.task.deserializers;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.IntNode;
import com.openx.task.model.User;
import com.openx.task.provider.UserProvider;

import java.io.IOException;

public class UserDeserializer extends StdDeserializer<User> {
    public UserDeserializer() {
        this(null);
    }

    public UserDeserializer(Class<?> vc) {
        super(vc);
    }
    @Override
    public User deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JacksonException {
        JsonNode node = jp.getCodec().readTree(jp);
        int id = node.asInt();
        return getUserById(id);

    }


    private User getUserById(int userId) throws JsonProcessingException {

        for (User user : UserProvider.fetchedUsers) {
            if (user.getId() == userId) {
                return user;
            }
        }
        throw new IllegalArgumentException("User with ID " + userId + " not found");
    }
}
