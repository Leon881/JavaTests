package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;



public class RegistrationTests {

    public static WebDriver driver;
    public static RegistrationPage page;
    public static String URL = "https://demoqa.com/automation-practice-form";


    @BeforeEach
    public void setUp(){
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
    }

    @Test
    public void registrationTest(){
        page = new RegistrationPage(driver, URL);
        page.OpenPage();
        page.setFooterPosition();
        page.inputFirstName("firstName");
        page.inputLastName("lastname");
        page.inputEmail("vadim@example.com");
        page.chooseMaleGender();
        page.inputPhone("1234567890");
        page.selectDate();
        page.inputSubject("Test");
        page.chooseHobbieSport();
        page.uploadFile();
        page.inputAddress("Test");
        page.selectState();
        page.selectCity();
        page.submit();
        page.shouldExistsResponseForm();

    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
