package com.interview.demo.api;

import com.interview.demo.api.util.HelloTestHelper;
import com.interview.demo.entity.Hello;
import com.interview.demo.repository.HelloRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerTestWithRestAssured {

    @Autowired
    HelloRepository helloRepository;

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setup() {
        helloRepository.deleteAll();
    }

    @Test
    public void getHello() {

        var hello = new Hello();
        hello.setName("Bojan");
        helloRepository.saveAndFlush(hello);

        var response = HelloTestHelper.getHelloSuccessful("Bojan", HelloTestHelper.getURL(port));
        assertThat(response.name()).isEqualTo("Bojan");

    }

}
