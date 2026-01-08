package com.rohansamanta.jenkinsautomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FirstTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
               driver.manage().window().maximize();
               driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
               driver.get("https://rohans2001.github.io/");

        String title = driver.getTitle();
        if("Rohan Samanta".equals(title)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }
        driver.quit();

    }
}
