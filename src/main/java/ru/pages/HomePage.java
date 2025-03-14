package ru.pages;

import ru.locators.AllLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class HomePage {

    private WebDriver driver;
    private By homeHeader = AllLocators.MAIN_HEADER;
    private By fqaHeader = AllLocators.SUB_HEADER;
    private By accordionItemButton = AllLocators.ACCORDION_BUTTON;
    private By accordionItemText = AllLocators.ACCORDION_PANEL;
    private By OrderButtonHeader = AllLocators.ORDER_BUTTON_HEADER;
    private By OrderButtonMiddle = AllLocators.ORDER_BUTTON_MIDDLE;

    String headerText = "Самокат на пару дней Привезём его прямо к вашей двери, а когда накатаетесь — заберём";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isHomePageLoaded() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeHeader));
        String actualHeaderText = driver.findElement(homeHeader).getText();
        return actualHeaderText.equals(headerText);
    }

    public void scrollToSubHeader() {
        WebElement element = driver.findElement(accordionItemButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void scrollToMiddleOrderButton() {
        WebElement element = driver.findElement(OrderButtonMiddle);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }


    public String textInFaqHeader() {
        return driver.findElement(fqaHeader).getText();
    }

    public void clickAccordionItemButton() {
        driver.findElement(accordionItemButton).click();
    }

    public String textInAccardeon() {
        return driver.findElement(accordionItemText).getText();
    }

    public void clickOrderButtonHeader() {
        driver.findElement(OrderButtonHeader).click();
    }

    public void clickOrderButtonMiddle() {
        driver.findElement(OrderButtonMiddle).click();
    }

}