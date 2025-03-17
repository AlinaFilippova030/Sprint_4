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

    private By aboutRentPageHeader = By.xpath(".//div[@class='Order_Content__bmtHS']/div[@class='Order_Header__BZXOb' and text()='Про аренду']");
    private By rentDateValue = By.xpath(".//div[@class='Order_Form__17u6u']//input[@placeholder='* Когда привезти самокат']");
    private By rentTimeInput = By.xpath(".//div[@class='Dropdown-placeholder' and text()='* Срок аренды']");
    private By pickDateMarch17 = By.xpath(".//div[contains(@class, 'react-datepicker__day') and contains(text(), '20') and contains(@aria-label, 'марта 2025')]");
    private By pickDateMarch18 = By.xpath(".//div[contains(@class, 'react-datepicker__day') and contains(text(), '21') and contains(@aria-label, 'марта 2025')]");
    private By pickTimeOneDay = By.xpath(".//div[contains(@class, 'Dropdown-option') and contains(text(), 'сутки')]");
    private By pickTimeThreeDays = By.xpath(".//div[contains(@class, 'Dropdown-option') and contains(text(), 'трое суток')]");
    private By PickTimeValue = By.xpath(".//div[contains(@class, 'Dropdown-placeholder') and contains(@class, 'is-selected')]");

    private By blackColorCheckBox = By.xpath(".//input[@id='black']");
    private By greyColorCheckBox = By.xpath(".//input[@id='grey']");
    private By colorValue = By.xpath(".//label[@for='black' or @for='grey']");
    private By blackCheckBoxText = By.xpath(".//label[@for='black']");
    private By greyCheckBoxText = By.xpath(".//label[@for='grey']");

    private By commentValue = By.xpath(".//div[@class='Input_InputContainer__3NykH']//input[@placeholder='Комментарий для курьера']");

    private By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    private By orderConfirmationHeader = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and contains(text(), 'Хотите оформить заказ?')]");
    private By confirmOrderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");

    private By orderPlacedHeaderText = By.xpath(".//div[contains(@class, 'Order_ModalHeader__3FDaJ') and contains(text(), 'Заказ оформлен')]");
    private By checkStatusButton = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button[text()='Посмотреть статус']");
    private By cancelOrderButton = By.xpath(".//button[contains(@class, 'Button_Button__ra12g') and contains(@class, 'Button_Middle__1CSJM') and contains(@class, 'Button_Inverted__3IF-i') and text()='Отменить заказ']");




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
        driver.findElement(rentDateValue).click();
    }

    // метод для нажатия на дату1 заказа
    public void clickPickDate() {
        driver.findElement(pickDateMarch17).click();
    }

    // метод для нажатия на дату2 заказа
    public void clickPickDate2() {
        driver.findElement(pickDateMarch18).click();
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
        driver.findElement(pickTimeOneDay).click();
    }

    // метод получения срок аренды Значения
    public String getPickTimeText() {
        return driver.findElement(PickTimeValue).getText();
    }

    // метод для нажатия на поле срок в выпадающем списке2
    public void clickPickTime2() {
        driver.findElement(pickTimeThreeDays).click();
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
        assertTrue(driver.findElement(commentValue).isEnabled());
        driver.findElement(commentValue).clear();
        driver.findElement(commentValue).sendKeys(inputCommentEmpty);
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