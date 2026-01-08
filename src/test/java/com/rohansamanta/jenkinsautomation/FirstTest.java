package com.rohansamanta.jenkinsautomation;

import io.qameta.allure.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;

public class FirstTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();

        // Headless configuration
        options.addArguments("--headless=new"); // Chrome 109+
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");

        driver = new ChromeDriver(options);

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

    @AfterMethod(alwaysRun = true)
    public void captureScreenshotOnFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            saveScreenshot();
        }
        tearDown();
    }

    @Attachment(value = "Screenshot on failure", type = "image/png")
    public byte[] saveScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
