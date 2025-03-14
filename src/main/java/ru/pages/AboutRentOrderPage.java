package ru.pages;

import ru.locators.AllLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertTrue;

public class AboutRentOrderPage {
    private WebDriver driver;

    private By aboutRentPageHeader = AllLocators.RENT_PAGE_HEADER;
    private By rentDateInput = AllLocators.RENT_DATE_INPUT;
    private By rentTimeInput = AllLocators.RENT_TIME_INPUT;
    private By pickDate = AllLocators.RENT_DATE_SELECTOR;
    private By pickDate2 = AllLocators.RENT_DATE_SELECTOR2;
    private By pickTime = AllLocators.RENT_TIME;
    private By pickTime2 = AllLocators.RENT_TIME2;
    private By blackColorCheckBox = AllLocators.CHECK_BOX_COLOR_BLACK;
    private By greyColorCheckBox = AllLocators.CHECK_BOX_COLOR_GREY;
    private By commentInput = AllLocators.COMMENT_INPUT;
    private By orderButton = AllLocators.ORDER_BUTTON;
    private By orderConfirmationHeader = AllLocators.ORDER_CONFIRMATION_HEADER;
    private By confirmOrderButton = AllLocators.ORDER_CONFIRMATION_BUTTON;
    private By confirmationMessageHeader = AllLocators.ORDER_CONFIRMATION_TEXT;
    private By checkStatusButton = AllLocators.CHECK_SATSTUS_BUTTON;

    String rentOrderPageText = "Про Аренду";

    public AboutRentOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // метод для проверки открытия стр Про Аренду
    public boolean isAboutRentOrderPageLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(aboutRentPageHeader));
        String actualAboutRentPageHeaderText = driver.findElement(aboutRentPageHeader).getText();
        return actualAboutRentPageHeaderText.equals(rentOrderPageText);
    }

    // Метод для получения текста заголовка
    public String getHeaderText() {
        return driver.findElement(aboutRentPageHeader).getText();
    }

    // метод для нажатия на поле Дата
    public void clickRentDateInput() {
        driver.findElement(rentDateInput).click();
    }

    // метод для нажатия на дату1 заказа
    public void clickPickDate() {
        driver.findElement(pickDate).click();
    }

    // метод для нажатия на дату2 заказа
    public void clickPickDate2() {
        driver.findElement(pickDate2).click();
    }

    // метод для проверки открытости поля «ДАТА», удаления текста из неё и ввода нового значения из параметра
    public void emptyRentDateInput(String inputRentDateEmpty) {
        assertTrue(driver.findElement(rentDateInput).isEnabled());
        driver.findElement(rentDateInput).clear();
        driver.findElement(rentDateInput).sendKeys(inputRentDateEmpty);
    }

    // метод для нажатия на поле срок аренды
    public void clickRentTimeInput() {
        driver.findElement(rentTimeInput).click();
    }

    // метод для нажатия на поле срок в выпадающем списке
    public void clickPickTime() {
        driver.findElement(pickTime).click();
    }

    // метод для нажатия на поле срок в выпадающем списке2
    public void clickPickTime2() {
        driver.findElement(pickTime2).click();
    }

    // метод для нажатия на чекбокс "Черный жемчуг"
    public void clickBlackColorCheckBox() {
        driver.findElement(blackColorCheckBox).click();
    }

    // метод для нажатия на чекбокс "серая безысходность"
    public void clickGreyColorCheckBox() {
        driver.findElement(greyColorCheckBox).click();
    }

    // Метод для проверки, выбран ли чекбокс "чёрный жемчуг"
    public boolean isBlackColorCheckBoxSelected() {
        return driver.findElement(blackColorCheckBox).isSelected();
    }

    // Метод для проверки, выбран ли чекбокс "серая безысходность"
    public boolean isGreyColorCheckBoxSelected() {
        return driver.findElement(greyColorCheckBox).isSelected();
    }

    // метод для проверки открытости поля «Комментарий для курьера», удаления текста из неё и ввода нового значения из параметра
    public void emptyCommentInput(String inputCommentEmpty) {
        assertTrue(driver.findElement(commentInput).isEnabled());
        driver.findElement(commentInput).clear();
        driver.findElement(commentInput).sendKeys(inputCommentEmpty);
    }

    // метод нажатия кнопки заказать
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    // метод для проверки открытия стр подтверждения заказа
    public boolean isOrderConfirmationHeader() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderConfirmationHeader));
        String actualOrderConfirmationHeaderText = driver.findElement(orderConfirmationHeader).getText();
        return actualOrderConfirmationHeaderText.equals("Заказ оформлен");
    }

    // метод нажатия кнопки ДА
    public  void clickConfirmOrderButton() {
        driver.findElement(confirmOrderButton).click();
    }

//    // Метод для получения текста заголовка "Заказ оформлен"
//    public String getConfirmationMessageHeaderText() {
//        return driver.findElement(confirmationMessageHeader).getText();
//    }

    public String getConfirmationMessageHeaderText() {
        WebElement element = driver.findElement(confirmationMessageHeader);
        String fullText = element.getText();
        // Извлекаем первую строку текста (до переноса строки)
        String firstLine = fullText.split("\n")[0];
        return firstLine.trim(); // Убираем лишние пробелы
    }

    public void clickCheckStatusButton() {
        driver.findElement(checkStatusButton).click();
    }

    public String checkStatusButtonText() {
        return driver.findElement(checkStatusButton).getText();
    }




}