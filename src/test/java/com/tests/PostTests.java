package com.tests;

import com.pojo.Employee;
import com.pojo.FavFoods;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Arrays;

import static com.requestbuilder.RequestBuilder.buildRequestForPostCalls;
import static com.utils.RandomUtils.*;


public class PostTests {

    @Test
    public void postCallTest(){

        FavFoods favFoods=FavFoods.builder().breakfast("poha").lunch("roti").dinner(Arrays.asList("pizza","doodh")).build();
        Employee employee=Employee.builder().id(getId()).firstName(getFirstName()).lastName(getFirstName()).email(getEmail())
                .jobs(Arrays.asList("Dev","QA"))
                .favFoods(favFoods).build();

       Response response= buildRequestForPostCalls()
                .body(employee)
                .post("/employees");

        Assertions.assertThat(response.getStatusCode())
                .isEqualTo(201);
    }
}
