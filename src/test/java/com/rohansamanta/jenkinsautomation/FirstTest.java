package com.rohansamanta.jenkinsautomation;

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
    public void verifyWebsiteTitle() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "Rohan Samanta";

        Assert.assertEquals(actualTitle, expectedTitle, "Title does not match!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

