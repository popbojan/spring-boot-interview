package com.interview.demo.service;

import com.interview.demo.entity.Hello;
import com.interview.demo.repository.HelloRepository;
import com.interview.demo.service.impl.DefaultHelloService;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HelloServiceWithMockito {

    @InjectMocks
    private DefaultHelloService helloService;

    @Mock
    private HelloRepository helloRepository;

    @Test
    public void returnsHelloWithAProvidedName() {
        final var name = RandomStringUtils.random(20);
        final var hello = new Hello();
        hello.setName(name);

        when(helloRepository.findByName(anyString())).thenReturn(Optional.ofNullable(hello));

        Optional<Hello> result = helloService.getHelloMessage(name);


        assertThat(result.isPresent());
        assertThat(result.get().getName()).isEqualTo(name);
    }
}
