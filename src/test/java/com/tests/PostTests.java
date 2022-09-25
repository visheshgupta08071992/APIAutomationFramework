package com.tests;

import com.constants.FrameworkConstants;
import com.pojo.Employee;
import com.pojo.FavFoods;
import com.reports.ExtentReport;
import com.utils.ApiUtils;
import com.utils.RandomUtils;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;

import static com.requestbuilder.RequestBuilder.buildRequestForPostCalls;
import static com.utils.RandomUtils.*;


public class PostTests extends BaseTest  {

    @Test
    public void verifyEmployeeRecordIsAdded(){

        FavFoods favFoods=FavFoods.builder().breakfast("poha").lunch("roti").dinner(Arrays.asList("pizza","doodh")).build();
        Employee employee=Employee.builder().id(getId()).firstName(getFirstName()).lastName(getFirstName()).email(getEmail())
                .jobs(Arrays.asList("Dev","QA"))
                .favFoods(favFoods).build();

       Response response= buildRequestForPostCalls()
                .body(employee)
                .post("/employees");

       //Verify Status Code
        Assertions.assertThat(response.getStatusCode())
                .isEqualTo(201);

        //Verify response Schema
        response.then().body(JsonSchemaValidator.matchesJsonSchema(new File(FrameworkConstants.getResponseSchemaPath() + "EmployeeSchema.json")));

        //Logging the response to extent report
        ExtentReport.logResponse(response.asPrettyString());
    }


    @Test
    public void verifyEmployeeRecordIsAddedUsingExternalFile(Method method) throws IOException {
        String resource = ApiUtils.readJsonandGetAsString(FrameworkConstants.getRequestFolderPath() + "request.json")
                                   .replace("number", String.valueOf(RandomUtils.getId()))
                                   .replace("firstName",RandomUtils.getFirstName())
                .replace("lastName",RandomUtils.getLastName())
                .replace("emailID",RandomUtils.getEmail());

        Response response= buildRequestForPostCalls()
                .body(resource)
                .post("/employees");

        response.prettyPrint();

        //Store response in output folder by method name
        ApiUtils.storeStringAsJsonFile(FrameworkConstants.getResponseFolderPath() + method.getName() + ".json",response);

        //Verify Status Code
        Assertions.assertThat(response.getStatusCode())
                .isEqualTo(201);

        //Verify response Schema
        response.then().body(JsonSchemaValidator.matchesJsonSchema(new File(FrameworkConstants.getResponseSchemaPath() + "EmployeeSchema1.json")));

        //Logging the response to extent report
        ExtentReport.logResponse(response.asPrettyString());

    }
}
