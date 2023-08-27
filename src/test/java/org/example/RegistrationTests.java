package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class RegistrationTests {

    public static WebDriver driver;
    public static RegistrationPage page;
    public String URL = "https://demoqa.com/automation-practice-form";


    @BeforeEach
    public void setUp(){
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(this.URL);
    }

    @Test
    public void registrationTest(){
        page = new RegistrationPage(driver);
        page.inputFirstName("firstName");
        page.inputLastName("lastname");
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
