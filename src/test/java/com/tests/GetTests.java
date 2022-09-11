package com.tests;

import com.utils.ApiUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;
import static io.restassured.RestAssured.given;

public class GetTests {

    @Test
    public void getEmployeeDetails(){
      Response  respnose = ApiUtils
              .buildRequestForGetCalls()
              .header("Content-Type", ContentType.JSON)
              .get("/employees");

      respnose.prettyPrint();

      //Using assertj assert
      assertThat(respnose.getStatusCode())
                .isEqualTo(200);

      //RootNode of Json is depicted by $

      assertThat(respnose.jsonPath().getList("$").size())
      .isPositive()
      .as("Validating Size of Employee Array")
              .isGreaterThan(30);
    }

    @Test
    public void getEmployeesDetails(){
        Response  respnose = ApiUtils
                .buildRequestForGetCalls()
                .pathParam("id",1)
                .header("Content-Type", ContentType.JSON)
                .get("/employees/{id}");

        respnose.prettyPrint();

        //Using assertj assert
        assertThat(respnose.getStatusCode()).isEqualTo(200);

        //RootNode of Json is depicted by $

        assertThat(respnose.jsonPath()
                .getString("last_name"))
                .as("Validating last Name")
                .isEqualTo("Eschweiler");
    }
}


