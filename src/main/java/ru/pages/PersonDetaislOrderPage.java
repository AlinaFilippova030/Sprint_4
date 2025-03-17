package ru.pages;

import ru.locators.AllLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import ru.texts.Texts;

import static org.junit.Assert.assertTrue;

public class PersonDetaislOrderPage {
    private WebDriver driver;

    private By personDetaislPageHeader = By.xpath(".//div[@class='Order_Header__BZXOb']");
    private By clientNameValue = By.xpath(".//div[@class='Order_Form__17u6u']//input[@placeholder='* Имя']");
    private By clientSurnameValue = By.xpath(".//div[@class='Order_Form__17u6u']//input[@placeholder='* Фамилия']");
    private By clientAdressValue = By.xpath(".//div[@class='Order_Form__17u6u']//input[@placeholder='* Адрес: куда привезти заказ']");
    private By metroInput = By.xpath(".//div[@class='Order_Form__17u6u']//input[@placeholder='* Станция метро']");
    private By metroSelectorFilled = By.xpath("//input[contains(@class, 'select-search__input') and contains(@value, 'Красносельская')]");
    private By metroStationList = By.xpath(".//div[@class='select-search__select']");
    private By metroStation = By.xpath(".//div[contains(@class, 'select-search__select')]//*[contains(text(), 'Красносельская') or contains(@value, 'Красносельская') or contains(@data-value, 'Красносельская')]");
    private By metroStation2 = By.xpath(".//div[contains(@class, 'select-search__select')]//*[contains(text(), 'Лубянка') or contains(@value, 'Лубянка') or contains(@data-value, 'Лубянка')]");
    private By clientPhoneValue = By.xpath(".//div[@class='Order_Form__17u6u']//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By nextButton = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button[text()='Далее']");


    public PersonDetaislOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isPersonDetaislPageLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(personDetaislPageHeader));
        String actualHeaderText = driver.findElement(personDetaislPageHeader).getText();
        return actualHeaderText.equals(personDetaislPageHeader);
    }

    public String textInPersonDetailsPageHeader() {
        return driver.findElement(personDetaislPageHeader).getText();
    }

    // метод для проверки открытости поля «ИМЯ», удаления текста из неё и ввода нового значения из параметра
    public void emptyNameInput(String inputNameEmpty) {
        assertTrue(driver.findElement(clientNameValue).isEnabled());
        driver.findElement(clientNameValue).clear();
        driver.findElement(clientNameValue).sendKeys(inputNameEmpty);
    }

    // метод получения Имя Клиента
    public String getPersonNameValue() {
        return driver.findElement(clientNameValue).getAttribute("value");
    }

    // метод для проверки открытости поля «Фамилия», удаления текста из неё и ввода нового значения из параметра
    public void emptySurnameInput(String inputSurnameEmpty) {
        assertTrue(driver.findElement(clientSurnameValue).isEnabled());
        driver.findElement(clientSurnameValue).clear();
        driver.findElement(clientSurnameValue).sendKeys(inputSurnameEmpty);
    }

    public String getPersonSurnameValue() {
        return driver.findElement(clientSurnameValue).getAttribute("value");
    }

    // метод для проверки открытости поля «Адресс», удаления текста из неё и ввода нового значения из параметра
    public void emptyAdressInput(String inputAdressEmpty) {
        assertTrue(driver.findElement(clientAdressValue).isEnabled());
        driver.findElement(clientAdressValue).clear();
        driver.findElement(clientAdressValue).sendKeys(inputAdressEmpty);
    }

    public String getClientAdressValue() {
        return driver.findElement(clientAdressValue).getAttribute("value");
    }

    // метод для нажатия на селектор Стация Метро
    public void clickMetroSelector() {
        driver.findElement(metroInput).click();
    }

    // метод ожидания загрузки списка Стаций Метро
    public void MetroListLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.visibilityOfElementLocated(metroStationList));
    }

    // метод для нажатия на станцию "Красносельская"
    public void clickMetroStation() {
        driver.findElement(metroStation).click();
    }

    public String getMetroStationValue() {
        return driver.findElement(metroInput).getAttribute("value");
    }

    // метод для нажатия на станцию "Лубянка"
    public void clickMetroStation2() {
        driver.findElement(metroStation2).click();
    }

    // дождаться, чтобы текст в элементе «Селектор Метро» стал равен значению из параметра
    public void waitForChangMetroStation(String newMetroStation) {
        new WebDriverWait(driver, 3).until(
                ExpectedConditions.textToBePresentInElementValue(metroSelectorFilled, newMetroStation)
        );
    }

    // метод для проверки открытости поля «Телефон», удаления текста из неё и ввода нового значения из параметра
    public void emptyPhoneInput(String InputPhoniEmpty) {
        assertTrue(driver.findElement(clientPhoneValue).isEnabled());
        driver.findElement(clientPhoneValue).clear();
        driver.findElement(clientPhoneValue).sendKeys(InputPhoniEmpty);
    }

    public String getPhoneNumberValue() {
        return driver.findElement(clientPhoneValue).getAttribute("value");
    }


    // метод для нажатия на кнопку Далее
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

}
