package com.check24.demo.api;

import com.check24.demo.api.dto.HelloDTO;
import com.check24.demo.entity.Hello;
import com.check24.demo.repository.HelloRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponentsBuilder;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class HelloControllerTests {

    @Autowired
    private TestRestTemplate template;

    @Autowired
    HelloRepository helloRepository;

    @Before
    public void beforeEach() {
        helloRepository.deleteAll();
    }

    @Test
    public void getHello() throws Exception {

        var hello = new Hello();
        hello.setName("Bojan");
        helloRepository.saveAndFlush(hello);

        var uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/").queryParam("name", "Bojan").build().toUri();
        ResponseEntity<HelloDTO> response = template.getForEntity(uri, HelloDTO.class);

        assertThat(response.getBody().name()).isEqualTo("Bojan");
    }
}
