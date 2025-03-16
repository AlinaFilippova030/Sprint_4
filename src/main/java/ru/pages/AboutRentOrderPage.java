package ru.pages;

import ru.locators.AllLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.texts.Texts;

import static org.junit.Assert.assertTrue;

public class AboutRentOrderPage {
    private WebDriver driver;

    private By aboutRentPageHeader = AllLocators.RENT_PAGE_HEADER;
    private By rentDateInput = AllLocators.RENT_DATE_INPUT;
    private By rentTimeInput = AllLocators.RENT_TIME_INPUT;
    private By rentDateValue = AllLocators.RENT_DATE_VALUE;
    private By pickDate = AllLocators.RENT_DATE_SELECTOR;
    private By pickDate2 = AllLocators.RENT_DATE_SELECTOR2;
    private By pickTime = AllLocators.RENT_TIME;
    private By pickTime2 = AllLocators.RENT_TIME2;
    private By PickTimeValue = AllLocators.RENT_TIME_VALUE;
    private By blackColorCheckBox = AllLocators.CHECK_BOX_COLOR_BLACK_CHECKED;
    private By greyColorCheckBox = AllLocators.CHECK_BOX_COLOR_GREY_CHECKED;
    private By colorValue = AllLocators.COLOR_VALUE;

    private By blackCheckBoxText = AllLocators.CHECK_BOX_COLOR_BLACK_TEXT;
    private By greyCheckBoxText = AllLocators.CHECK_BOX_COLOR_GREY_TEXT;


    private By commentInput = AllLocators.COMMENT_INPUT;
    private By commentValue = AllLocators.COMMENT_VALUE;
    private By orderButton = AllLocators.ORDER_BUTTON;

    private By orderConfirmationHeader = AllLocators.ORDER_CONFIRMATION_HEADER;
    private By confirmOrderButton = AllLocators.ORDER_CONFIRMATION_BUTTON;
    private By confirmationMessageHeader = AllLocators.ORDER_CONFIRMATION_TEXT;

    private By orderPlacedHeaderText =AllLocators.ORDER_PLACED_HEADER_TEXT;
    private By checkStatusButton = AllLocators.CHECK_SATSTUS_BUTTON;
    private By cancelOrderButton = AllLocators.CANCEL_ORDER_BUTTON;




    public AboutRentOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // метод для проверки открытия стр Про Аренду
    public boolean isAboutRentOrderPageLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(aboutRentPageHeader));
        String actualAboutRentPageHeaderText = driver.findElement(aboutRentPageHeader).getText();
        return actualAboutRentPageHeaderText.equals(Texts.ABOUT_RENT_PAGE_HEADER_TEXT);
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

    // Метод получения даты аренды Значение
    public String getRentDateValue() {
        return driver.findElement(rentDateValue).getAttribute("value");
    }

    // метод для нажатия на поле срок аренды
    public void clickRentTimeInput() {
        driver.findElement(rentTimeInput).click();
    }

    // метод для нажатия на поле срок в выпадающем списке
    public void clickPickTime() {
        driver.findElement(pickTime).click();
    }

    // метод получения срок аренды Значения
    public String getPickTimeText() {
        return driver.findElement(PickTimeValue).getText();
    }

    // метод для нажатия на поле срок в выпадающем списке2
    public void clickPickTime2() {
        driver.findElement(pickTime2).click();
    }


    // метод получения цвета самоката Значения
    public String getColorValue() {
        if (isBlackColorCheckBoxSelected()) {
            return driver.findElement(blackCheckBoxText).getText();
        } else if (isGreyColorCheckBoxSelected()) {
            return driver.findElement(greyCheckBoxText).getText();
        }
        return "Ни один чекбокс не выбран";
    }

    // Метод для нажатия на чекбокс "Черный жемчуг"
    public void clickBlackColorCheckBox() {
        driver.findElement(blackColorCheckBox).click();
    }

    // Метод для нажатия на чекбокс "серая безысходность"
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

    // Метод получения Комментария Значение
    public String getCommentValue() {
        return driver.findElement(commentValue).getAttribute("value");
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
        return actualOrderConfirmationHeaderText.equals(Texts.PLACE_ORDER_TEXT);
    }

    // Метод получения текста Хедера Хотите оформить заказ?
    public String getOrderConfirmationHeader() {
        return driver.findElement(orderConfirmationHeader).getText().replace("\n", " ").trim();
    }

    // метод нажатия кнопки ДА
    public  void clickConfirmOrderButton() {
        driver.findElement(confirmOrderButton).click();
    }


    //       Метод для получения текста заголовка "Заказ оформлен"
    public String getOrderPlacedHeaderText() {
        WebElement element = driver.findElement(orderPlacedHeaderText);
        String fullText = element.getText();
        String firstLine = fullText.split("\n")[0];
        return firstLine.trim();
    }


    public void clickCheckStatusButton() {
        driver.findElement(checkStatusButton).click();
    }

    public String getCancelOrderButtonText() {
        return driver.findElement(cancelOrderButton).getText();
    }


}