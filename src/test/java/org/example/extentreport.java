package org.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class extentreport {
    ExtentReports extents;
    @BeforeTest
    public void config()
    {
        String path =System.getProperty("user.dir")+"\\reports\\index.html";
        ExtentSparkReporter report = new ExtentSparkReporter(path);
        report.config().setReportName("Automation result");
        report.config().setDocumentTitle("test results");

         extents = new ExtentReports();
        extents.attachReporter(report);
        extents.setSystemInfo("tester","Veera");


    }


    @Test

    public void demo()
    {
        extents.createTest("Initial");
        System.setProperty("webdriver.chrome.driver","C:\\users\\veeraragavan.r\\chromedriver.exe");
        WebDriver  driver = new ChromeDriver();
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        extents.flush();



    }
}
