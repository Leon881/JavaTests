package org.example;

import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


public class RegistrationTests {

    public static WebDriver driver;
    public static RegistrationPage page;
    public static String URL = "https://demoqa.com/automation-practice-form";

    Calendar date = Calendar.getInstance();
    String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August",
            "September", "October", "November", "December"};
    String SearchingDay = "15";

    // Словарь для проверки введенных в форму данных
    Map<String, String> FormFields = new HashMap<String, String>() {{
        put("FirstName", "TestFirstName");
        put("LastName", "TestLastName");
        put("Email", "vadim@example.com");
        put("Gender", "Male");
        put("Phone", "1234567890");
        put("Date", SearchingDay + " " + monthNames[date.get(Calendar.MONTH)] + "," + date.get(Calendar.YEAR));
        put("Subject", "Test");
        put("Hobbies", "Sports");
        put("FileName", "test_image.jpg");
        put("Address", "TestAddress");
        put("State", "NCR");
        put("City", "Delhi");
    }};


    @BeforeEach
    public void setUp() {
        // Используем WebDriverManager, чтобы самостоятельно не скачивать драйвер
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
    }

    @Description("Проверка открытия формы и введенных данных")
    @Test
    public void registrationTest() {
        page = new RegistrationPage(driver, URL);
        page.OpenPage();
        // Сделал у footer position relative, потому что он мешал нажатию кнопки submit (ее не было видно)
        page.setFooterPosition();
        page.inputFirstName(FormFields.get("FirstName"));
        page.inputLastName(FormFields.get("LastName"));
        page.inputEmail(FormFields.get("Email"));
        page.chooseMaleGender();
        page.inputPhone(FormFields.get("Phone"));
        page.selectDate(SearchingDay);
        page.inputSubject(FormFields.get("Subject"));
        page.chooseHobbieSport();
        page.uploadFile(FormFields.get("FileName"));
        page.inputAddress(FormFields.get("Address"));
        page.selectState();
        page.selectCity();
        page.submit();
        page.shouldExistsResponseForm();
        page.shouldResultBeRight(FormFields);

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
