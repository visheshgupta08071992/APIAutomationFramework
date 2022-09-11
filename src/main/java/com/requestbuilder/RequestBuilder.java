package com.requestbuilder;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

//Made this class final as does not want anyone to extend it
public final class RequestBuilder {

    //Made the constructer private as does not want anyone to create its object
    private RequestBuilder(){}

    public static RequestSpecification buildRequestForGetCalls(){
        return   given()
                .baseUri("http://localhost:3000")
                .log().all();
    }

    public static RequestSpecification buildRequestForPostCalls(){
        return   buildRequestForGetCalls()
                .contentType(ContentType.JSON);
    }
}
