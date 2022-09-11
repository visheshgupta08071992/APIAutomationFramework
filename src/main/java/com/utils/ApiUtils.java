package com.utils;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

//Made this class final as does not want anyone to extend it
public final class ApiUtils {

    //Made the constructer private as does not want anyone to create its object
    private ApiUtils(){}

    public static RequestSpecification buildRequestForGetCalls(){
        return   given()
                .baseUri("http://localhost:3000")
                .log().all();
    }
}
