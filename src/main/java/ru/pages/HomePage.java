package ru.pages;

import ru.texts.Texts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class HomePage {

    private WebDriver driver;
    private  By homeHeader = By.xpath(".//div[@class='Home_Header__iJKdX']");
    private  By accordionItemButton = By.xpath(".//div[@class='accordion__button']");
    private  By accordionItemText = By.xpath(" .//div[@class='accordion__panel']");
    private  By OrderButtonHeader = By.xpath(".//div/button[@class='Button_Button__ra12g']");
    private  By OrderButtonMiddle = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isHomePageLoaded() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeHeader));
        String actualHeaderText = driver.findElement(homeHeader).getText();
        return actualHeaderText.equals(Texts.MAIN_PAGE_HEADER_TEXT);
    }

    public String textInMainHeader() {
        return driver.findElement(homeHeader).getText().replace("\n", " ").trim();
    }

    public void scrollToSubHeader() {
        WebElement element = driver.findElement(accordionItemButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void scrollToMiddleOrderButton() {
        WebElement element = driver.findElement(OrderButtonMiddle);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickAccordionItemButton (int index) {
        driver.findElements(accordionItemButton).get(index).click();
    }

    public String getAccordionButtonText (int index) {
        return driver.findElements(accordionItemButton).get(index).getText();
    }

    public String textInAccordion (int index) {
        return driver.findElements(accordionItemText).get(index).getText();
    }

    public void clickOrderButtonHeader() {
        driver.findElement(OrderButtonHeader).click();
    }

    public void clickOrderButtonMiddle() {
        driver.findElement(OrderButtonMiddle).click();
    }
}