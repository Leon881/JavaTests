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
    public static WebElement PhoneField;

    @FindBy(id="dateOfBirthInput")
    public static WebElement DateOfBirthField;

    @FindBy(id="currentAddress")
    public static WebElement AddressField;

    @FindBy(xpath = "//*[@id=\"subjectsInput\"]")
    public static WebElement SubjectField;



    public void inputFirstName(String firstName) {
        FirstNameField.sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        LastNameField.sendKeys(lastName);
    }

    public void inputEmail(String email) {
        EmailField.sendKeys(email);
    }

    public void inputPhone(String phone) {
        PhoneField.sendKeys(phone);
    }

    public void inputSubject(String subject) {
        SubjectField.sendKeys(subject);
    }

    public void inputAddress(String address) {
        AddressField.sendKeys(address);
    }
}
