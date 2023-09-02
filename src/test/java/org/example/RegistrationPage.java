package org.example;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class RegistrationPage extends BasePage {

    public RegistrationPage (WebDriver webdriver, String url) {
        super (webdriver, url);
    }

    @FindBy(id="firstName")
    public static WebElement FirstNameField;

    @FindBy(id="lastName")
    public static WebElement LastNameField;

    @FindBy(id="userEmail")
    public static WebElement EmailField;

    @FindBy(id="submit")
    public static WebElement Submit;

    @FindBy(id="userNumber")
    public static WebElement PhoneField;

    @FindBy(id="dateOfBirthInput")
    public static WebElement DateOfBirthField;

    @FindBy(css="#genterWrapper > div.col-md-9.col-sm-12 > div:nth-child(1) > label")
    public static WebElement MaleGender;

    @FindBy(css="#hobbiesWrapper > div.col-md-9.col-sm-12 > div:nth-child(1) > label")
    public static WebElement HobbiesCheckboxSport;

    @FindBy(id="currentAddress")
    public static WebElement AddressField;

    @FindBy(id="uploadPicture")
    public static WebElement UlpoadInput;

    @FindBy(xpath = "//*[@id=\"state\"]")
    public static WebElement StateField;

    @FindBy(id="react-select-3-option-0")
    public static WebElement StateFieldOption0;

    @FindBy(id="city")
    public static WebElement CityField;

    @FindBy(id="react-select-4-option-0")
    public static WebElement CityFieldOption0;
    
    @FindBy(xpath = "//*[@id=\"subjectsInput\"]")
    public static WebElement SubjectField;

    @FindAll({@FindBy(className = "react-datepicker__day")})
    public static List<WebElement> DaysInCalendar;

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

    public void chooseMaleGender() {
        MaleGender.click();
    }

    public void inputAddress(String address) {
        AddressField.sendKeys(address);
    }

    public void chooseHobbieSport() {
        HobbiesCheckboxSport.click();
    }

    public void uploadFile() {
        UlpoadInput.sendKeys("C://Users/Vadim/IdeaProjects/Silicium_Task/src/test/java/org/example/test_files/test_image.jpg");
    }

    public void selectState() {
        new Actions(webdriver)
                .scrollToElement(Submit)
                .perform();
        StateField.click();
        Boolean elementPresent = WaitElementPresence(3, "id", "react-select-3-option-0");
        if (elementPresent) {
            StateFieldOption0.click();
        }
    }

    public void selectCity() {
        Boolean elementClickable = WaitElementBeClickable(5, CityField);
        if (elementClickable){
            CityField.click();
        }
        Boolean elementPresent = WaitElementPresence(3, "id", "react-select-4-option-0");
        if (elementPresent) {
            CityFieldOption0.click();
        }
    }

    public void selectDate() {
        DateOfBirthField.click();
        Boolean elementPresent = WaitElementPresence(3, "class", "react-datepicker");
        if (elementPresent) {
            DaysInCalendar.get(0).click();
        }
    }

    public void submit(){
        Submit.click();
    }

    public void setFooterPosition(){
        ((JavascriptExecutor)webdriver).executeScript("document.getElementsByTagName('footer')[0].style.position='relative'");
    }

}
