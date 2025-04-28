package ru.middle.oder.button.test;

import org.junit.After;
import org.junit.Test;
import ru.pages.AboutRentOrderPage;
import ru.pages.HomePage;
import ru.pages.PersonDetaislOrderPage;
import ru.utils.BrowserUtils;
import ru.config.Config;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import ru.utils.WebDriverFactory;

@RunWith(Parameterized.class)
public class MiddleOrderButtonTest {
    private WebDriver driver;

    // Параметры
    private String nameInput;
    private String surnameInput;
    private String adressInput;
    private String metroInput;
    private String phoneInput;
    private String pickDate;
    private String pickTime;
    private String colorCheckBox;
    private String commentInput;

    // Конструктор для параметров
    public MiddleOrderButtonTest(String nameInput, String surnameInput, String adressInput, String metroInput,
                                 String phoneInput, String pickDate, String pickTime, String colorCheckBox, String commentInput) {
        this.nameInput = nameInput;
        this.surnameInput = surnameInput;
        this.adressInput = adressInput;
        this.metroInput = metroInput;
        this.phoneInput = phoneInput;
        this.pickDate = pickDate;
        this.pickTime = pickTime;
        this.colorCheckBox = colorCheckBox;
        this.commentInput = commentInput;
    }

    @Parameterized.Parameters
    public static Object[] [] getTestData() {
        return new Object[] []{
                {"Джон", "Хокинс", "Бользаковский пруд", "Красносельская", "+79114900988", "20.03.2025", "сутки", "чёрный жемчуг", "Дрова со двора"},
                {"Иван", "Крузенштерн", "Семеновская роща 15", "Лубянка", "+79213458909", "21.03.2025", "трое суток", "серая безысходность", "Подъезд со двора"}
        };
    }


    @Before
    public void setUp() {
        String browser = Config.getBrowser(); // Получаем значение из файла config.properties
        driver = WebDriverFactory.createDriver(browser); // Создаем драйвер через фабрику
        driver.manage().window().maximize();
    }

@Test
public void FillOrderDetailsPageMiddleTest() {
    // Домашнаяя стр
    HomePage objHomePage = new HomePage(driver);
    objHomePage.isHomePageLoaded();
    objHomePage.scrollToMiddleOrderButton();
    objHomePage.clickOrderButtonMiddle();

    // стр Для кого самокат
    PersonDetaislOrderPage objPersonDetaislOrderPage = new PersonDetaislOrderPage(driver);
    objPersonDetaislOrderPage.fillClientDetails(nameInput, surnameInput, adressInput, phoneInput, metroInput);
    objPersonDetaislOrderPage.clickNextButton();

    // стр Про аренду
    AboutRentOrderPage objAboutRentOrderPage = new AboutRentOrderPage(driver);
    objAboutRentOrderPage.fillRentDetails(pickDate, pickTime, colorCheckBox, commentInput);
}

@After
public void tearDown() {
    BrowserUtils.closeBrowser(driver);
}
}