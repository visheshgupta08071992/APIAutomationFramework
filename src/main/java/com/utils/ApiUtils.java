package com.utils;

//Making the class as final as does not want anyone to extend it

import io.restassured.response.Response;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class ApiUtils {

    //Making the constructer as private as does not want anyone to create its object
    private ApiUtils(){}

    public static String readJsonandGetAsString(String filepath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filepath)));
    }

    public static void storeStringAsJsonFile(String filepath, Response response) throws IOException {
        Files.write(Paths.get(filepath),response.asByteArray());
    }

}

