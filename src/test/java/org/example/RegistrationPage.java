package org.example;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver webdriver, String url) {
        super(webdriver, url);
    }

    @FindBy(id = "firstName")
    public static WebElement FirstNameField;

    @FindBy(id = "lastName")
    public static WebElement LastNameField;

    @FindBy(id = "userEmail")
    public static WebElement EmailField;

    @FindBy(id = "submit")
    public static WebElement Submit;

    @FindBy(id = "userNumber")
    public static WebElement PhoneField;

    @FindBy(id = "dateOfBirthInput")
    public static WebElement DateOfBirthField;

    @FindBy(css = "#genterWrapper > div.col-md-9.col-sm-12 > div:nth-child(1) > label")
    public static WebElement MaleGender;

    @FindBy(css = "#hobbiesWrapper > div.col-md-9.col-sm-12 > div:nth-child(1) > label")
    public static WebElement HobbiesCheckboxSport;

    @FindBy(id = "currentAddress")
    public static WebElement AddressField;

    @FindBy(id = "uploadPicture")
    public static WebElement UploadInput;

    @FindBy(xpath = "//*[@id=\"state\"]")
    public static WebElement StateField;

    @FindBy(id = "react-select-3-option-0")
    public static WebElement StateFieldOption0;

    @FindBy(id = "city")
    public static WebElement CityField;

    @FindBy(id = "react-select-4-option-0")
    public static WebElement CityFieldOption0;

    @FindBy(xpath = "//*[@id=\"subjectsInput\"]")
    public static WebElement SubjectField;

    @FindBy(id = "example-modal-sizes-title-lg")
    public static WebElement ResponseFormHeader;

    @FindAll({@FindBy(className = "react-datepicker__day")})
    public static List<WebElement> DaysInCalendar;

    @FindAll({@FindBy(tagName = "td")})
    public static List<WebElement> ResultsInForm;

    // Словарь для локаторов, которые отправляются в качестве аргументов функций
    Map<String, String> Locators = new HashMap<String, String>() {{
        put("FirstElementInStateSelect", "react-select-3-option-0");
        put("FirstElementInCitySelect", "react-select-4-option-0");
        put("Calendar", "react-datepicker");
        put("Modal", "modal");
    }};

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

    // Динамически задаем имя файла
    public void uploadFile(String fileName) {
        UploadInput.sendKeys("C://Users/Vadim/IdeaProjects/Silicium_Task/src/test/java/org/example/test_files/%s".formatted(fileName));
    }

    public void selectState() {
        // Прокручиваем страницу вниз до кнопки submit
        new Actions(webdriver).scrollToElement(Submit).perform();
        StateField.click();
        // Ожидаем появление расскрывающегося списка
        Boolean elementPresent = WaitElementPresence(3, "id", Locators.get("FirstElementInStateSelect"));
        if (elementPresent) {
            StateFieldOption0.click();
        }
    }

    public void selectCity() {
        // Ожидаем пока второй select станет кликабельным
        Boolean elementClickable = WaitElementBeClickable(5, CityField);
        if (elementClickable) {
            CityField.click();
        }
        // Ожидаем появление расскрывающегося списка
        Boolean elementPresent = WaitElementPresence(3, "id", Locators.get("FirstElementInCitySelect"));
        if (elementPresent) {
            CityFieldOption0.click();
        }
    }

    public void selectDate(String SearchingDay) {
        DateOfBirthField.click();
        Boolean elementPresent = WaitElementPresence(3, "class", Locators.get("Calendar"));
        if (elementPresent) {
            // Элементы одной страницы календаря собраны в листе DaysInCalendar
            for (WebElement webElement : DaysInCalendar) {
                // Проходим по датам, сверяя с заданной
                if (Objects.equals(webElement.getText(), SearchingDay)) {
                    webElement.click();
                    break;
                }

            }
        }
    }

    public void submit() {
        Submit.click();
    }

    public void setFooterPosition() {
        // Изменение position у футер. Напрямую использую js
        ((JavascriptExecutor) webdriver).executeScript("document.getElementsByTagName('footer')[0].style.position='relative'");
    }

    public void shouldExistsResponseForm() {
        assert WaitElementPresence(10, "class", Locators.get("Modal")) : "Response form did not appear";
        String headerFormText = ResponseFormHeader.getText();
        assert Objects.equals(headerFormText, "Thanks for submitting the form") : "Header text is not right";
    }

    public void shouldResultBeRight(Map<String, String> FormFields) {
        // Все элементы таблицы модального окна собраты в лист ResultsInForm
        assert Objects.equals(ResultsInForm.get(1).getText(), FormFields.get("FirstName") + " " + FormFields.get("LastName")) : "Name is not right";
        assert Objects.equals(ResultsInForm.get(3).getText(), FormFields.get("Email")) : "Email is not right";
        assert Objects.equals(ResultsInForm.get(5).getText(), FormFields.get("Gender")) : "Gender is not right";
        assert Objects.equals(ResultsInForm.get(7).getText(), FormFields.get("Phone")) : "Phone is not right";
        assert Objects.equals(ResultsInForm.get(9).getText(), FormFields.get("Date")) : "Date is not right";
        //assert Objects.equals(ResultsInForm.get(11).getText(), FormFields.get("Subject")) : "Subject is not right";
        assert Objects.equals(ResultsInForm.get(13).getText(), FormFields.get("Hobbies")) : "Hobbies is not right";
        assert Objects.equals(ResultsInForm.get(15).getText(), FormFields.get("FileName")) : "File is not right";
        assert Objects.equals(ResultsInForm.get(17).getText(), FormFields.get("Address")) : "Address is not right";
        assert Objects.equals(ResultsInForm.get(19).getText(), FormFields.get("State") + " " + FormFields.get("City")) : "State and City are not right";
    }

}
