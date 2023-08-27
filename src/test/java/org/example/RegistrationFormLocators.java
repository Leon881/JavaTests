package org.example;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

public class RegistrationFormLocators {

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
}
