package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class RegistrationPage extends BasePage {

    public RegistrationPage (WebDriver webdriver) {
        super (webdriver);
    }

    @FindBy(id="firstName")
    public static WebElement FirstNameField;

    @FindBy(id="lastName")
    public static WebElement LastNameField;

    @FindBy(id="userEmail")
    public static WebElement EmailField;

    @FindBy(id="userNumber")
    public static WebElement NumberField;

    @FindBy(id="dateOfBirthInput")
    public static WebElement DateOfBirthField;

    @FindBy(xpath = "//*[@id=\"subjectsContainer\"]/div/div[1]")
    public static WebElement SubjectsField;



    public void inputFirstName(String firstName) {
        FirstNameField.sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        LastNameField.sendKeys(lastName);
    }
}
