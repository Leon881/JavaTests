package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// Базовый класс. Тут собрал методы, которые будут общими для других классов-страниц
public class BasePage {

    public WebDriver webdriver;
    public String url;

    public BasePage(WebDriver webdriver, String url) {
        this.webdriver = webdriver;
        this.url = url;
        PageFactory.initElements(webdriver, this);
        webdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void OpenPage() {
        webdriver.get(url);
    }

    // Ожидание появление элемента. Нужно задать тег и локатор
    public Boolean WaitElementPresence(Integer timeout, String locatorType, String locator) {
        WebDriverWait wait = new WebDriverWait(webdriver, Duration.ofSeconds(timeout));
        try {
            switch (locatorType.toLowerCase()) {
                case "id" -> wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));
                case "class" -> wait.until(ExpectedConditions.presenceOfElementLocated(By.className(locator)));
                default -> {
                }
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    // Ожидание пока элемент станет кликабельным
    public Boolean WaitElementBeClickable(Integer timeout, WebElement element) {
        WebDriverWait wait = new WebDriverWait(webdriver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            return false;
        }
        return true;
    }


}
