package com.rohansamanta.jenkinsautomation;

import io.qameta.allure.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirstTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rohans2001.github.io/");
    }

    @Test
    @Description("Verify website title is correct")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyWebsiteTitle() {
        String actualTitle = getWebsiteTitle();
        String expectedTitle = "Rohan Samanta";

        Assert.assertEquals(actualTitle, expectedTitle, "Title does not match!");
    }

    @Step("Getting website title")
    public String getWebsiteTitle() {
        return driver.getTitle();
    }

    @AfterMethod
    @Attachment(value = "Screenshot on failure", type = "image/png")
    public byte[] captureScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
    public void tearDown() {
        driver.quit();
    }
}

