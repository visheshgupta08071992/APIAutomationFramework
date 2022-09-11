package com.tests;


import com.github.javafaker.Faker;
import com.google.common.io.Files;
import com.pojo.Employee;
import com.pojo.FavFoods;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static io.restassured.RestAssured.given;

public class GetTests {

    @Test
    public void getRequest(){
        Map<String,Object> map = new LinkedHashMap<String, Object>();
        map.put("id",new Faker().number().randomDigit());
        map.put("firstName",new Faker().name().firstName());
        map.put("lastName",new Faker().name().lastName());
        map.put("jobs", Arrays.asList("tester","trainer"));

        Map<String,Object> favFood = new LinkedHashMap<String, Object>();
        favFood.put("breakfast",new Faker().name().firstName());
        favFood.put("lunch",new Faker().name().lastName());
        favFood.put("dinner", Arrays.asList("tester","trainer"));

        map.put("favfoods",favFood);
        System.out.println(map);

      Response  respnose = given().log().all()
              .header("Content-Type", ContentType.JSON)
              .body(map)
              .post("http://localhost:3000/employees");

      respnose.prettyPrint();

    }
}


