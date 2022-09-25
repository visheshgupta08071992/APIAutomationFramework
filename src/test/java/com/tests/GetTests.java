package com.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.reports.ExtentReport;
import com.requestbuilder.RequestBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;
import static io.restassured.RestAssured.given;

public class GetTests extends BaseTest {

    @Test
    public void verifyAllEmployeeDetails(){
      Response  respnose = RequestBuilder
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

        //Logging the response to extent report
        ExtentReport.logResponse(respnose.asPrettyString());

    }

    @Test(dataProvider = "getData")
    public void verifySpecificEmployeeDetails(Integer id,String lastName){
        Response  respnose = RequestBuilder
                .buildRequestForGetCalls()
                .pathParam("id",id)
                .header("Content-Type", ContentType.JSON)
                .get("/employees/{id}");

        respnose.prettyPrint();

        //Using assertj assert
        assertThat(respnose.getStatusCode()).isEqualTo(201);

        //RootNode of Json is depicted by $

        assertThat(respnose.jsonPath()
                .getString("last_name"))
                .as("Validating last Name")
                .isEqualTo(lastName);

        //Logging the response to extent report
        ExtentReport.logResponse(respnose.asPrettyString());
    }

    @DataProvider
    public Object[][] getData(){
        return new Object[][] {{1,"Eschweiler"},{4,"Eschweiler"},{251,"Dickens"}};
        }
}


