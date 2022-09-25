package com.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import lombok.Getter;
import lombok.Setter;
import org.testng.ITestResult;

public final class ExtentReport {

    private ExtentReport(){}
    private static ExtentReports extent;
    private @Getter @Setter static ExtentTest test;


    private static ThreadLocal<ExtentTest> exTest= new ThreadLocal<>();

    public static void initReports(){
        extent  = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("index.html");
        extent.attachReporter(sparkReporter);
    }

    public static void tearDownReports(){
        extent.flush();
    }

    public static void createTest(String name) {
        test=extent.createTest(name);
        setTest(test);
    }

    public static void logResponse(String message){
        getTest().pass(MarkupHelper.createCodeBlock(message, CodeLanguage.JSON));
    }

}
