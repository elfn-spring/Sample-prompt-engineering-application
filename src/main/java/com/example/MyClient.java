package com.example;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.stereotype.Component;

/**
 * @Author: Elimane
 */
@Component
public class MyClient {

    private final ChatClient client;

    public MyClient(ChatModel model) {
        this.client = ChatClient.builder(model).build();
    }

    public String call(String message) {
        return client.prompt().user(message).call().content();
    }

}
