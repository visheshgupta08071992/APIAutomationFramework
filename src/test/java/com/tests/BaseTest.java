package com.tests;

import com.aventstack.extentreports.ExtentTest;
import com.reports.ExtentReport;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class BaseTest {

   /* @BeforeSuite
    public void setUpSuite(){
        ExtentReport.initReports();
    }

    @AfterSuite
    public void tearDownSuite(){
        ExtentReport.tearDownReports();
    }

    @BeforeMethod
    public void setUp(Method method){
        ExtentReport.createTest(method.getName());
    }

    @AfterMethod
    public void tearDown(ITestResult result){
        if(!result.isSuccess()){
             ExtentReport.logFailResponse(result);
        }
    }*/

}

