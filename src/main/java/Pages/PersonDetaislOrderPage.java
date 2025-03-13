package Pages;

import locators.AllLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import static org.junit.Assert.assertTrue;

public class PersonDetaislOrderPage {
    private WebDriver driver;

    private By OrderButtonHeader = AllLocators.ORDER_BUTTON_HEADER;
    private By personDetaislPageHeader = AllLocators.ORDER_PAGE_HEADER;
    private By nameInput = AllLocators.NAME_INPUT;
    private By surnameInput = AllLocators.SURNAME_INPUT;
    private By adressInput = AllLocators.ADRESS_INPUT;
    private By metroSelector = AllLocators.METRO_SELECTOR;
    private By metroSelectorFilled = AllLocators.METRO_SELECTOR_FILLED;
    private By metroStationList = AllLocators.METRO_LIST;
    private By metroStation = AllLocators.STATION_KRASNOSELSKAYA;
    private By metroStation2 = AllLocators.STATION_LYBIANKA;
    private By phoneInput = AllLocators.PHONE_INPUT;
    private By nextButton = AllLocators.NEXT_BUTTON;

    String personDetaislPageHeaderText = "Имя";

    public PersonDetaislOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOrderButtonHeader() {
        driver.findElement(OrderButtonHeader).click();
    }

    public boolean isPersonDetaislPageLoaded() {
    WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(personDetaislPageHeader));
    String actualHeaderText = driver.findElement(personDetaislPageHeader).getText();
        return actualHeaderText.equals(personDetaislPageHeader);
}
    // метод для проверки открытости поля «ИМЯ», удаления текста из неё и ввода нового значения из параметра
    public void emptyNameInput(String inputNameEmpty) {
        assertTrue(driver.findElement(nameInput).isEnabled());
        driver.findElement(nameInput).clear();
        driver.findElement(nameInput).sendKeys(inputNameEmpty);
    }

    // метод для проверки открытости поля «Фамилия», удаления текста из неё и ввода нового значения из параметра
    public void emptySurnameInput(String inputSurnameEmpty) {
        assertTrue(driver.findElement(surnameInput).isEnabled());
        driver.findElement(surnameInput).clear();
        driver.findElement(surnameInput).sendKeys(inputSurnameEmpty);
    }

    // метод для проверки открытости поля «Адресс», удаления текста из неё и ввода нового значения из параметра
    public void emptyAdressInput(String inputAdressEmpty) {
        assertTrue(driver.findElement(adressInput).isEnabled());
        driver.findElement(adressInput).clear();
        driver.findElement(adressInput).sendKeys(inputAdressEmpty);
    }

    // метод для нажатия на селектор Стация Метро
    public void clickMetroSelector() {

        driver.findElement(metroSelector).click();
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

    // метод для нажатия на станцию "Лубянка"
    public void clickMetroStation2() {
        driver.findElement(metroStation2).click();
    }



    public void waitForChangMetroStation(String newMetroStation) {
        // дождаться, чтобы текст в элементе «Селектор Метро» стал равен значению из параметра
        new WebDriverWait(driver, 3).until(
                ExpectedConditions.textToBePresentInElementValue(metroSelectorFilled, newMetroStation)
        );
    }

    // метод для проверки открытости поля «Телефон», удаления текста из неё и ввода нового значения из параметра
    public void emptyPhoneInput(String InputPhoniEmpty) {
        assertTrue(driver.findElement(phoneInput).isEnabled());
        driver.findElement(phoneInput).clear();
        driver.findElement(phoneInput).sendKeys(InputPhoniEmpty);
    }

    // метод для нажатия на кнопку Далее
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

}
