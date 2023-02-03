package com.interview.demo.api.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.interview.demo.api.dto.HelloDTO;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.http.HttpStatus;

import java.util.Optional;

import static io.restassured.RestAssured.given;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class HelloTestHelper {

    private static final String HELLO_PATH = "/hello";

    public static HelloDTO getHelloSuccessful(final String name, final String url) {
        return getHello(name, url, HttpStatus.SC_OK).as(new TypeReference<HelloDTO>() {}.getType());
    }

    private static ExtractableResponse<Response> getHello(final String name, final String url, final int status) {
        final var requestSpecification = given().when();
        Optional.ofNullable(name).ifPresent(param -> requestSpecification.queryParam("name", param));
        return requestSpecification.get(String.format(url + HELLO_PATH)).then().statusCode(status).extract();
    }

    public static String getURL(final int port){
        return String.format("http://localhost:%s", port);
    }

}
