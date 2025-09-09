package com.testapp.ui;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class LoginUITest {
    private WebDriver driver;

    @Before
    public void setUp() {
        // Chỉ định đường dẫn đến ChromeDriver
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testLoginSuccess() {
        driver.get("http://localhost:8080/TestApp/login.jsp");
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("1234");
        driver.findElement(By.id("loginBtn")).click();

        String pageTitle = driver.getTitle();
        assertEquals("Home Page", pageTitle);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}