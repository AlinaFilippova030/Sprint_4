package HeaderOderButtonTest;

import Pages.AboutRentOrderPage;
import Pages.HomePage;
import Pages.PersonDetaislOrderPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;


@RunWith(Parameterized.class)
public class HeaderOderButtonTest {
    private WebDriver driver;

    // Параметры
    private String nameInput;
    private String surnameInput;
    private String adressInput;
    private String metroStation;
    private String phoneInput;
    private String pickDate;
    private String pickTime;
    private String blackColorCheckBox;
    private String commentInput;

    // Конструктор для параметров
    public HeaderOderButtonTest(String nameInput, String surnameInput, String adressInput, String metroStation,
                                 String phoneInput, String pickDate, String pickTime, String blackColorCheckBox, String commentInput) {
        this.nameInput = nameInput;
        this.surnameInput = surnameInput;
        this.adressInput = adressInput;
        this.metroStation = metroStation;
        this.phoneInput = phoneInput;
        this.pickDate = pickDate;
        this.pickTime = pickTime;
        this.blackColorCheckBox = blackColorCheckBox;
        this.commentInput = commentInput;
    }

    @Parameterized.Parameters
    public static Object[] [] getTestData() {
        return new Object[] []{
                {"Джон", "Хокинс", "Бользаковский пруд", "Красносельская", "+79114900988", "17", "сутки", "чёрный жемчуг", "Дрова со двора"},
                {"Иван", "Крузенштерн", "Семеновская роща 15", "Лубянка", "+79213458909", "18", "трое суток", "серая безысходность", "Подъезд со двора"}
        };
    }

    @Before
    public void setUp() {

 //       CHROME DRIVER
        String driverPath = "chromedriver";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
    }

////          FIREFOX DRIVER
//        // Укажите путь к geckodriver, если он не в PATH
//        System.setProperty("webdriver.gecko.driver", "geckodriver");
//
//        // Настройка Firefox (опционально)
//        FirefoxProfile profile = new FirefoxProfile();
//        FirefoxOptions options = new FirefoxOptions();
//        options.setBinary("/Applications/Firefox.app/Contents/MacOS/firefox"); // Путь к Firefox на macOS
//        profile.setPreference("javascript.enabled", true); // Включить JavaScript
//        options.setProfile(profile);
//
//        // Инициализация FirefoxDriver
//        driver = new FirefoxDriver(options);
//
//    }

    @Test
    public void FillOrderDetailsPageHeader() {
        HomePage objHomePage = new HomePage(driver);
        objHomePage.isHomePageLoaded();
        PersonDetaislOrderPage objPersonDetaislOrderPage = new PersonDetaislOrderPage(driver);

        objHomePage.clickOrderButtonHeader();
        objPersonDetaislOrderPage.isPersonDetaislPageLoaded();

        // переменная со значением, для поля ИМЯ
//        String nameInput = "Иван";
        // в одном шаге проверь, что поле «Занятие» доступно для редактирования, и введи в него новое значение
        objPersonDetaislOrderPage.emptyNameInput(nameInput);
//        String surnameInput = "Крузенштерн";
        objPersonDetaislOrderPage.emptySurnameInput(surnameInput);
//        String adressInput = "Семеновская роща 15";
        objPersonDetaislOrderPage.emptyAdressInput(adressInput);

//        objPersonDetaislOrderPage.clickMetroSelector();
//        objPersonDetaislOrderPage.MetroListLoad();
//        objPersonDetaislOrderPage.clickMetroStation();

        objPersonDetaislOrderPage.clickMetroSelector();
        if (metroStation.equals("Красносельская")) {
            objPersonDetaislOrderPage.clickMetroStation();
        } else if (metroStation.equals("Лубянка")) {
            objPersonDetaislOrderPage.clickMetroStation2();
        }


        // проверь, что поле «Станция метро» поменяло значение на новое
//        String newMetroStation = "Красносельская";
 //       objPersonDetaislOrderPage.waitForChangMetroStation(newMetroStation);

        // проверь, что поле «Телефон»  поменяло значение на новое
 //       String phoneInput = "+79213458909";
        objPersonDetaislOrderPage.emptyPhoneInput(phoneInput);

        objPersonDetaislOrderPage.clickNextButton();

        AboutRentOrderPage objAboutRentOrderPage = new AboutRentOrderPage(driver);
        objAboutRentOrderPage.isAboutRentOrderPageLoad();

        // Проверка текста заголовка
        String expectedHeaderText = "Про аренду";
        String actualHeaderText = objAboutRentOrderPage.getHeaderText();
        if (actualHeaderText.equals(expectedHeaderText)) {
            System.out.println("Текст заголовка корректен: " + actualHeaderText);
        } else {
            System.out.println("Текст заголовка некорректен. Ожидалось: " + expectedHeaderText + ", но найдено: " + actualHeaderText);
        }


//        objAboutRentOrderPage.clickRentDateInput();
//        objAboutRentOrderPage.clickPickDate();
        objAboutRentOrderPage.clickRentDateInput();
        if (pickDate.equals("17")) {
            objAboutRentOrderPage.clickPickDate();
        } else if (pickDate.equals("18")) {
            objAboutRentOrderPage.clickPickDate2();
        }

//        objAboutRentOrderPage.clickRentTimeInput();
//        //       String dateInput = "13.03.2025";
//        //       objAboutRentOrderPage.emptyRentDateInput(dateInput);
//        objAboutRentOrderPage.clickPickTime();

        objAboutRentOrderPage.clickRentTimeInput();
        if (pickTime.equals("сутки")) {
            objAboutRentOrderPage.clickPickTime();
        } else if (pickTime.equals("трое суток")) {
            objAboutRentOrderPage.clickPickTime2();
        }

//        objAboutRentOrderPage.clickBlackColorCheckBox();
        if (blackColorCheckBox.equals("чёрный жемчуг")) {
            objAboutRentOrderPage.clickBlackColorCheckBox();
        } else if (blackColorCheckBox.equals("серая безысходность")) {
            objAboutRentOrderPage.clickGreyColorCheckBox();
        }

        if (objAboutRentOrderPage.isBlackColorCheckBoxSelected()) {
            System.out.println("Чекбокс 'чёрный жемчуг' выбран.");
        } else {
            System.out.println("Чекбокс 'чёрный жемчуг' не выбран.");
        }

        if (objAboutRentOrderPage.isGreyColorCheckBoxSelected()) {
            System.out.println("серая безысходность' выбран.");
        } else {
            System.out.println("серая безысходность' не выбран.");
        }

 //       String commentInput = "Подъезд со двора";
        objAboutRentOrderPage.emptyCommentInput(commentInput);

        objAboutRentOrderPage.clickOrderButton();

        objAboutRentOrderPage.isOrderConfirmationHeader();
        objAboutRentOrderPage.clickConfirmOrderButton();


        objAboutRentOrderPage.getConfirmationMessageHeaderText();

        String expectedConfirmationMessageHeaderText = "Заказ оформлен";
        String actualConfirmationMessageHeaderText = objAboutRentOrderPage.getConfirmationMessageHeaderText();

        if (actualConfirmationMessageHeaderText.equals(expectedConfirmationMessageHeaderText)) {
            System.out.println("Текст заголовка корректен: " + actualConfirmationMessageHeaderText);
        } else {
            System.out.println("Текст заголовка некорректен. Ожидалось: " + expectedConfirmationMessageHeaderText + ", но найдено: " + actualConfirmationMessageHeaderText);
        }

        objAboutRentOrderPage.clickCheckStatusButton();

    }



    @After
    public void tearDown() {
        driver.quit();
    }
}
