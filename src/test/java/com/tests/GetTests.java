package com.tests;

import Request.RequestBodies;
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

import static Request.RequestBodies.*;
import static io.restassured.RestAssured.given;

public class GetTests {

    /*
    * {
        "id":{{$randomInt}},
        "first_name": "{{$randomFirstName}}",
        "last_name": "{{$randomLastName}}",
        "email": "{{$randomEmail}}",
        "jobs":["Tester","Trainer"],
        "favFoods":{
            "breakfast":"idly",
            "lunch":"rice",
            "dinner":["Chapati","Milk"]
        }
      }
    *
    * */



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

    @Test
    public void getRequestUsingJsonObject(){
        JSONObject body=new JSONObject();
        body.put("id",new Faker().number().numberBetween(2,78905));
        body.put("firstName",new Faker().name().firstName());
        body.put("lastName",new Faker().name().lastName());

        JSONArray jobs = new JSONArray();
        jobs.put("tester");
        jobs.put("trainer");

        body.put("jobs",jobs);

        JSONObject subBody=new JSONObject();
        subBody.put("breakfast",new Faker().name().firstName());
        subBody.put("lunch",new Faker().name().lastName());
        subBody.put("dinner", Arrays.asList("tester","trainer"));

        body.put("favFoods",subBody);

        Response  respnose = given().log().all()
                .header("Content-Type", ContentType.JSON)
                .body(body.toString())
                .post("http://localhost:3000/employees");

        respnose.prettyPrint();

    }


    @Test
    public void getRequestUsingStaticMethodsWithinClass(){
        int id=new Faker().number().numberBetween(100,109803830);
        String firstName=new Faker().name().firstName();
        String lastName=new Faker().name().lastName();
        String emailAddress=new Faker().internet().emailAddress();
        List<String> jobs=new ArrayList<String>();
        jobs.add("\"tester\"");
        jobs.add("\"trainer\"");
        String breakfast=new Faker().name().firstName();
        String lunch=new Faker().name().username();
        List<String> dinner=new ArrayList<String>();
        dinner.add("\"tester\"");
        dinner.add("\"tester\"");



        Response  respnose = given().log().all()
                .header("Content-Type", ContentType.JSON)
                .body(addEmployee(id,firstName,lastName,emailAddress,jobs,breakfast,lunch,dinner))
                .post("http://localhost:3000/employees");

        respnose.prettyPrint();

    }

    @Test
    public void getRequestUsingPojo(){

        List<String> dinner=new ArrayList<String>();
        dinner.add("Chapati");
        dinner.add("Milk");
        FavFoods favFoods = new FavFoods("idly","rice",dinner);

        Employee employee = new Employee
                 ((int) new Faker().number().randomNumber()
                         ,new Faker().name().firstName()
                          ,new Faker().name().lastName()
                         ,new Faker().internet().emailAddress()
                         ,Arrays.asList("Tester,Trainer")
                         ,favFoods);


        Response  respnose = given().log().all()
                .header("Content-Type", ContentType.JSON)
                .body(employee)
                .post("http://localhost:3000/employees");

        respnose.prettyPrint();
    }

    @Test
    public void validateSchema(){


        Response  respnose = given().log().all()
                .header("Content-Type", ContentType.JSON)
                .body("{\n" +
                        "    \"id\": \"23484\",\n" +
                        "    \"jobs\": [\n" +
                        "        \"Tester,Trainer\"\n" +
                        "    ],\n" +
                        "    \"favFoods\": {\n" +
                        "        \"breakfast\": \"idly\",\n" +
                        "        \"lunch\": \"rice\",\n" +
                        "        \"dinner\": [\n" +
                        "            \"Chapati\",\n" +
                        "            \"Milk\"\n" +
                        "        ]\n" +
                        "    }\n" +
                        "}")
                .post("http://localhost:3000/employees");

        respnose.prettyPrint();

        Employee employee=respnose.as(Employee.class);
        System.out.println(employee.getId());



    }
}

