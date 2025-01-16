package com.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: Elimane
 */
@SpringBootTest
@ActiveProfiles("openid")
class MyClientTest {

    @Autowired
    private MyClient client;

    @Test
    void textCall() {
        String response = client.call("""
            What are the names of the five great lakes.
            Produce JSON output.
            """);
        Assertions.assertThat(response).contains(
                "Superior", "Huron", "Erie", "Michigan", "Ontario"
        );
        System.out.println("The response is: " + response);
    }
}
