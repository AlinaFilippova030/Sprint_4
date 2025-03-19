package ru.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import ru.texts.Texts;

import static org.junit.Assert.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PersonDetaislOrderPage {
    private WebDriver driver;

    private By personDetaislPageHeader = By.xpath(".//div[@class='Order_Header__BZXOb']");
    private By clientNameValue = By.xpath(".//div[@class='Order_Form__17u6u']//input[@placeholder='* Имя']");
    private By clientSurnameValue = By.xpath(".//div[@class='Order_Form__17u6u']//input[@placeholder='* Фамилия']");
    private By clientAdressValue = By.xpath(".//div[@class='Order_Form__17u6u']//input[@placeholder='* Адрес: куда привезти заказ']");
    private By metroInput = By.xpath(".//div[@class='Order_Form__17u6u']//input[@placeholder='* Станция метро']");
    private By metroStationList = By.xpath(".//div[@class='select-search__select']");
    private By metroStationKrasnaya = By.xpath(".//div[contains(@class, 'select-search__select')]//*[contains(text(), 'Красносельская') or contains(@value, 'Красносельская') or contains(@data-value, 'Красносельская')]");
    private By metroStationLybianak = By.xpath(".//div[contains(@class, 'select-search__select')]//*[contains(text(), 'Лубянка') or contains(@value, 'Лубянка') or contains(@data-value, 'Лубянка')]");
    private By clientPhoneValue = By.xpath(".//div[@class='Order_Form__17u6u']//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By nextButton = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button[text()='Далее']");

    public PersonDetaislOrderPage(WebDriver driver) {
        this.driver = driver;
    }


    public void fillClientDetails(String nameInput, String surnameInput, String adressInput, String phoneInput, String metroStation) {
  //       Проверка заголовка стр Для кого самокат
            WebDriverWait wait = new WebDriverWait(driver, 3);
            wait.until(ExpectedConditions.visibilityOfElementLocated(personDetaislPageHeader));
            String actualFillPersonalDetailsPageHeaderText = driver.findElement(personDetaislPageHeader).getText();
            assertThat("заголовок стр 'Для кого самокат' корректен.", actualFillPersonalDetailsPageHeaderText, is(Texts.FOR_WHO_SAMOKAT_PAGE_HEADER));
            System.out.println("PASSED: заголовок стр корректен: " + actualFillPersonalDetailsPageHeaderText);

        // Ввод и проверка имени
        inputAndCheckField(clientNameValue, nameInput, "Имя");

        // Ввод и проверка фамилии
        inputAndCheckField(clientSurnameValue, surnameInput, "Фамилия");

        // Ввод и проверка адреса
        inputAndCheckField(clientAdressValue, adressInput, "Адрес");

        // Выбор станции метро
        selectMetroStation(metroStation);

        // Ввод и проверка телефона
        inputAndCheckField(clientPhoneValue, phoneInput, "Телефон");
    }



    private void inputAndCheckField(By locator, String inputValue, String fieldName) {
        try {
            // Проверка, что поле доступно для ввода, Очистка поля и ввод нового значения
            assertTrue(driver.findElement(locator).isEnabled());
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(inputValue);

            // Получение введенного значения
            String actualValue = driver.findElement(locator).getAttribute("value");
            assertThat("Поле " + fieldName + " содержит корректное значение.", actualValue, is(inputValue));
            System.out.println("PASSED: Поле '" + fieldName + "' заполнено корректно. " + actualValue);
        } catch (AssertionError e) {
            System.out.println("FAILED: Поле '" + fieldName + "' заполнено некорректно. Ожидалось: " + inputValue + ", но найдено: " + e.getMessage());
            throw e; // Повторно выбрасываем исключение, чтобы тест завершился с ошибкой
        }
    }


    private void selectMetroStation(String stationName) {
        try {
            // Нажатие на селектор станции метро
            driver.findElement(metroInput).click();

            // Ожидание загрузки списка станций
            WebDriverWait wait = new WebDriverWait(driver, 8);
            wait.until(ExpectedConditions.visibilityOfElementLocated(metroStationList));

            // Выбор станции метро
            if (stationName.equals("Красносельская")) {
                driver.findElement(metroStationKrasnaya).click();
            } else if (stationName.equals("Лубянка")) {
                driver.findElement(metroStationLybianak).click();
            }

            // Получение выбранной станции метро
            String actualMetroValue = driver.findElement(metroInput).getAttribute("value");

            // Проверка, что станция метро выбрана корректно
            assertThat("Станция метро выбрана корректно.", actualMetroValue, is(stationName));
            System.out.println("PASSED: Станция метро выбрана корректно: " + actualMetroValue);
        } catch (AssertionError e) {
            System.out.println("FAILED: Станция метро выбрана некорректно. Ожидалось: " + stationName + ", но найдено: " + e.getMessage());
            throw e; // Повторно выбрасываем исключение, чтобы тест завершился с ошибкой
        }
    }

    // метод для нажатия на кнопку Далее
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }
}



