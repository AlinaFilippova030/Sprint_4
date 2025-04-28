package ru.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.texts.Texts;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AboutRentOrderPage {
    private WebDriver driver;

    private By aboutRentPageHeader = By.xpath(".//div[@class='Order_Content__bmtHS']/div[@class='Order_Header__BZXOb' and text()='Про аренду']");
    private By rentDateValue = By.xpath(".//div[@class='Order_Form__17u6u']//input[@placeholder='* Когда привезти самокат']");
    private By rentTimeInput = By.xpath(".//div[@class='Dropdown-placeholder' and text()='* Срок аренды']");
    private By pickDateMarch20 = By.xpath(".//div[contains(@class, 'react-datepicker__day') and contains(text(), '20') and contains(@aria-label, 'марта 2025')]");
    private By pickDateMarch21 = By.xpath(".//div[contains(@class, 'react-datepicker__day') and contains(text(), '21') and contains(@aria-label, 'марта 2025')]");
    private By pickTimeOneDay = By.xpath(".//div[contains(@class, 'Dropdown-option') and contains(text(), 'сутки')]");
    private By pickTimeThreeDays = By.xpath(".//div[contains(@class, 'Dropdown-option') and contains(text(), 'трое суток')]");
    private By PickTimeValue = By.xpath(".//div[contains(@class, 'Dropdown-placeholder') and contains(@class, 'is-selected')]");

    private By blackColorCheckBox = By.xpath(".//input[@id='black']");
    private By greyColorCheckBox = By.xpath(".//input[@id='grey']");
    private By blackCheckBoxText = By.xpath(".//label[@for='black']");
    private By greyCheckBoxText = By.xpath(".//label[@for='grey']");

    private By commentValue = By.xpath(".//div[@class='Input_InputContainer__3NykH']//input[@placeholder='Комментарий для курьера']");

    private By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    private By orderConfirmationHeader = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and contains(text(), 'Хотите оформить заказ?')]");
    private By confirmOrderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");

    private By orderPlacedHeaderText = By.xpath(".//div[contains(@class, 'Order_ModalHeader__3FDaJ') and contains(text(), 'Заказ оформлен')]");
    private By checkStatusButton = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button[text()='Посмотреть статус']");

    public AboutRentOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillRentDetails(String pickDate, String pickTime, String colorCheckBox, String commentInput) {
        try {
            // Проверка, что страница "Про аренду" загружена
            WebDriverWait wait = new WebDriverWait(driver, 3);
            wait.until(ExpectedConditions.visibilityOfElementLocated(aboutRentPageHeader));
            String actualHeaderText = driver.findElement(aboutRentPageHeader).getText();
            assertThat("Заголовок страницы 'Про аренду' корректен.", actualHeaderText, is(Texts.ABOUT_RENT_PAGE_HEADER_TEXT));
            System.out.println("PASSED: Страница 'Про аренду' загружена. Заголовок: " + actualHeaderText);

            // Выбор даты аренды
            driver.findElement(rentDateValue).click();
            if (pickDate.equals(Texts.MARCH20)) {
                driver.findElement(pickDateMarch20).click();
            } else if (pickDate.equals(Texts.MARCH21)) {
                driver.findElement(pickDateMarch21).click();
            }

            // Проверка выбранной даты
            String actualRentDateValue = driver.findElement(rentDateValue).getAttribute("value");
            assertThat("Дата аренды корректна.", actualRentDateValue, is(pickDate));
            System.out.println("PASSED: Дата аренды корректна: " + actualRentDateValue);

            // Выбор срока аренды
            driver.findElement(rentTimeInput).click();
            if (pickTime.equals(Texts.ONE_DAY)) {
                driver.findElement(pickTimeOneDay).click();
            } else if (pickTime.equals(Texts.THREE_DAYS_GRACE)) {
                driver.findElement(pickTimeThreeDays).click();
            }

            // Проверка выбранного срока аренды
            String actualPickTimeText = driver.findElement(PickTimeValue).getText();
            assertThat("Срок аренды корректен.", actualPickTimeText, is(pickTime));
            System.out.println("PASSED: Срок аренды корректен: " + actualPickTimeText);

            // Выбор цвета самоката
            if (colorCheckBox.equals(Texts.BLACK)) {
                driver.findElement(blackColorCheckBox).click();
            } else if (colorCheckBox.equals(Texts.GREY)) {
                driver.findElement(greyColorCheckBox).click();
            }

            // Проверка выбранного цвета
            String actualColorText = getColorValue();
            assertThat("Цвет самоката корректен.", actualColorText, is(colorCheckBox));
            System.out.println("PASSED: Цвет самоката корректен: " + actualColorText);

            // Ввод комментария
            driver.findElement(commentValue).clear();
            driver.findElement(commentValue).sendKeys(commentInput);

            // Проверка введенного комментария
            String actualCommentValue = driver.findElement(commentValue).getAttribute("value");
            assertThat("Комментарий корректен.", actualCommentValue, is(commentInput));
            System.out.println("PASSED: Комментарий корректен: " + actualCommentValue);

            // Нажатие кнопки "Заказать"
            driver.findElement(orderButton).click();

            // Проверка заголовка подтверждения заказа
            wait.until(ExpectedConditions.visibilityOfElementLocated(orderConfirmationHeader));
            String actualConfirmHeaderText = driver.findElement(orderConfirmationHeader).getText().replace("\n", " ").trim();
            assertThat("Заголовок подтверждения заказа корректен.", actualConfirmHeaderText, is(Texts.PLACE_ORDER_TEXT));
            System.out.println("PASSED: Заголовок подтверждения заказа корректен: " + actualConfirmHeaderText);

            // Нажатие кнопки "Да"
            driver.findElement(confirmOrderButton).click();
            // Проверка появления заголовка "Заказ оформлен" после нажатия кнопки "Да"
            try {
                // Проверка заголовка "Заказ оформлен"
                wait.until(ExpectedConditions.visibilityOfElementLocated(orderPlacedHeaderText));
                String actualConfirmationMessageHeaderText = driver.findElement(orderPlacedHeaderText).getText().split("Номер заказа")[0].replace("\n", " ").trim();
                assertThat("Заголовок 'Заказ оформлен' корректен.", actualConfirmationMessageHeaderText, is(Texts.ORDER_PLACED_TEXT));
                System.out.println("PASSED: Кнопка Да нажата, отображается заголовок: " + actualConfirmationMessageHeaderText);
            } catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
                System.out.println("FAILED: кнопка ДА нажата, заголовок \"" + Texts.ORDER_PLACED_TEXT + "\" не появился");
                throw e;
            } catch (AssertionError e) {
                System.out.println("FAILED: Заголовок 'Заказ оформлен' некорректен. Ожидалось: " + Texts.ORDER_PLACED_TEXT + ", но найдено: " + e.getMessage());
                throw e;
            }

            // Проверка заголовка "Заказ оформлен"
            wait.until(ExpectedConditions.visibilityOfElementLocated(orderPlacedHeaderText));
            String actualConfirmationMessageHeaderText = driver.findElement(orderPlacedHeaderText).getText().replace("\n", " ").trim();

// Используем регулярное выражение для извлечения только части текста до "Номер заказа"
            String extractedText = actualConfirmationMessageHeaderText.replaceAll(" Номер заказа.*", "").trim();
            assertThat("Заголовок корректен.", extractedText, is(Texts.ORDER_PLACED_TEXT));
            System.out.println("PASSED: Заголовок корректен: " + extractedText);

            // Нажатие кнопки "Посмотреть статус"
            driver.findElement(checkStatusButton).click();
        } catch (AssertionError e) {
            System.out.println("FAILED: Ошибка при заполнении данных аренды: " + e.getMessage());
            throw e; // Повторно выбрасываем исключение, чтобы тест завершился с ошибкой
        }
    }


    // Метод для получения цвета самоката
    public String getColorValue() {
        if (isBlackColorCheckBoxSelected()) {
            return driver.findElement(blackCheckBoxText).getText();
        } else if (isGreyColorCheckBoxSelected()) {
            return driver.findElement(greyCheckBoxText).getText();
        }
        return "Ни один чекбокс не выбран";
    }

    // Метод для проверки, выбран ли чекбокс "чёрный жемчуг"
    public boolean isBlackColorCheckBoxSelected() {
        return driver.findElement(blackColorCheckBox).isSelected();
    }

    // Метод для проверки, выбран ли чекбокс "серая безысходность"
    public boolean isGreyColorCheckBoxSelected() {
        return driver.findElement(greyColorCheckBox).isSelected();
    }

}