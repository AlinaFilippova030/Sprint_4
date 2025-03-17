package ru.middle.order.button.test;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.NoSuchElementException;
import ru.config.Config;
import ru.pages.AboutRentOrderPage;
import ru.pages.HomePage;
import ru.pages.PersonDetaislOrderPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import ru.texts.Texts;
import ru.utils.BrowserUtils;
import ru.utils.WebDriverFactory;

import static org.hamcrest.CoreMatchers.is;


@RunWith(Parameterized.class)
public class MiddleOrderButtonTest {
    private WebDriver driver;

    // Параметры
    private String nameInput;
    private String surnameInput;
    private String adressInput;
    private String metroStation;
    private String phoneInput;
    private String pickDate;
    private String pickTime;
    private String colorCheckBox;
    private String commentInput;

    // Конструктор для параметров
    public MiddleOrderButtonTest(String nameInput, String surnameInput, String adressInput, String metroStation,
                                 String phoneInput, String pickDate, String pickTime, String colorCheckBox, String commentInput) {
        this.nameInput = nameInput;
        this.surnameInput = surnameInput;
        this.adressInput = adressInput;
        this.metroStation = metroStation;
        this.phoneInput = phoneInput;
        this.pickDate = pickDate;
        this.pickTime = pickTime;
        this.colorCheckBox = colorCheckBox;
        this.commentInput = commentInput;
    }

    @Parameterized.Parameters
    public static Object[] [] getTestData() {
        return new Object[] []{
                {"Джон", "Хокинс", "Бользаковский пруд", "Красносельская", "+79114900988", "17.03.2025", "сутки", "чёрный жемчуг", "Дрова со двора"},
                {"Иван", "Крузенштерн", "Семеновская роща 15", "Лубянка", "+79213458909", "18.03.2025", "трое суток", "серая безысходность", "Подъезд со двора"}
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
        HomePage objHomePage = new HomePage(driver);
        objHomePage.isHomePageLoaded();
        PersonDetaislOrderPage objPersonDetaislOrderPage = new PersonDetaislOrderPage(driver);

        objHomePage.scrollToMiddleOrderButton();


        objHomePage.clickOrderButtonMiddle();
        String MiddleOrderButtonClicked = objPersonDetaislOrderPage.textInPersonDetailsPageHeader();
        MatcherAssert.assertThat(MiddleOrderButtonClicked, is(Texts.ORDER_CLIENT_PAGE_HEADER_TEXT));
        if (MiddleOrderButtonClicked.equals(Texts.ORDER_CLIENT_PAGE_HEADER_TEXT)) {
            System.out.println("PASSED: кнопка заказать В середине стр нажата, отображается стр: " + MiddleOrderButtonClicked);
        } else {
            System.out.println("FAILED: кнопка заказать  В середине стр не нажата, стр " + Texts.ORDER_CLIENT_PAGE_HEADER_TEXT + "не отображается!");
        }



        objPersonDetaislOrderPage.isPersonDetaislPageLoaded();

//         Заголовок стр Для кого самокат
        String actualPersonDetaislHeaderText = objPersonDetaislOrderPage.textInPersonDetailsPageHeader();
        MatcherAssert.assertThat(actualPersonDetaislHeaderText, is(Texts.ORDER_CLIENT_PAGE_HEADER_TEXT));
        if (actualPersonDetaislHeaderText.equals(Texts.ORDER_CLIENT_PAGE_HEADER_TEXT)) {
            System.out.println("PASSED: Текст заголовка стр корректен: " + actualPersonDetaislHeaderText);
        } else {
            System.out.println("FAILED: Текст заголовка стр некорректен. Ожидалось: " + Texts.ORDER_CLIENT_PAGE_HEADER_TEXT + ", но найдено: " + actualPersonDetaislHeaderText);
        }


        //       Имя
        objPersonDetaislOrderPage.emptyNameInput(nameInput);
        objPersonDetaislOrderPage.getPersonNameValue();

        String actualPersonNameValue = objPersonDetaislOrderPage.getPersonNameValue();
        MatcherAssert.assertThat(actualPersonNameValue, is(nameInput));

        if (actualPersonNameValue.equals(nameInput)) {
            System.out.println("PASSED: Имя пользователя корректено: " + actualPersonNameValue);
        } else {
            System.out.println("FAILED: Имя пользователя некорректен. Ожидалось: " + nameInput + ", но найдено: " + actualPersonNameValue);
        }

//       Фамилия
        objPersonDetaislOrderPage.emptySurnameInput(surnameInput);
        objPersonDetaislOrderPage.getPersonSurnameValue();

        String actualPersonSurnameValue = objPersonDetaislOrderPage.getPersonSurnameValue();
        MatcherAssert.assertThat(actualPersonSurnameValue, is(surnameInput));

        if (actualPersonSurnameValue.equals(surnameInput)) {
            System.out.println("PASSED: Фамилия пользователя корректено: " + actualPersonSurnameValue);
        } else {
            System.out.println("FAILED: Фамилия пользователя некорректен. Ожидалось: " + surnameInput + ", но найдено: " + actualPersonSurnameValue);
        }


//        Адрес
        objPersonDetaislOrderPage.emptyAdressInput(adressInput);
        objPersonDetaislOrderPage.getClientAdressValue();

        String actualClientAdressValue = objPersonDetaislOrderPage.getClientAdressValue();
        MatcherAssert.assertThat(actualClientAdressValue, is(adressInput));

        if (actualClientAdressValue.equals(adressInput)) {
            System.out.println("PASSED: Адрес пользователя корректен: " + actualClientAdressValue);
        } else {
            System.out.println("FAILED: Адрес пользователя некорректен. Ожидалось: " + adressInput + ", но найдено: " + actualClientAdressValue);
        }


//        Станция Метро
        objPersonDetaislOrderPage.clickMetroSelector();
        objPersonDetaislOrderPage.MetroListLoad();
        if (metroStation.equals("Красносельская")) {
            objPersonDetaislOrderPage.clickMetroStation();
        } else if (metroStation.equals("Лубянка")) {
            objPersonDetaislOrderPage.clickMetroStation2();
        }

        objPersonDetaislOrderPage.getMetroStationValue();
        String actualClientMetroValue = objPersonDetaislOrderPage.getMetroStationValue();
        MatcherAssert.assertThat(actualClientMetroValue, is(metroStation));

        if (actualClientMetroValue.equals(metroStation)) {
            System.out.println("PASSED: Станция метро корректена: " + actualClientMetroValue);
        } else {
            System.out.println("FAILED: Станция метро некорректена. Ожидалось: " + metroStation + ", но найдено: " + actualClientMetroValue);
        }

        objPersonDetaislOrderPage.clickMetroSelector();
        if (metroStation.equals("Красносельская")) {
            objPersonDetaislOrderPage.clickMetroStation();
        } else if (metroStation.equals("Лубянка")) {
            objPersonDetaislOrderPage.clickMetroStation2();
        }


//       Телефон
        objPersonDetaislOrderPage.emptyPhoneInput(phoneInput);
        objPersonDetaislOrderPage.getPhoneNumberValue();
        String actualClientPhoneNumberValue = objPersonDetaislOrderPage.getPhoneNumberValue();
        MatcherAssert.assertThat(actualClientPhoneNumberValue, is(phoneInput));

        if (actualClientPhoneNumberValue.equals(phoneInput)) {
            System.out.println("PASSED: Номер телефона корректен: " + actualClientPhoneNumberValue);
        } else {
            System.out.println("FAILED: Номер телефона некорректен. Ожидалось: " + phoneInput + ", но найдено: " + actualClientPhoneNumberValue);
        }


//      Кнопка далее
        objPersonDetaislOrderPage.clickNextButton();

        AboutRentOrderPage objAboutRentOrderPage = new AboutRentOrderPage(driver);
        objAboutRentOrderPage.isAboutRentOrderPageLoad();


//         Заголово стр Про Аренду
        String actualHeaderText = objAboutRentOrderPage.getHeaderText();

        MatcherAssert.assertThat(actualHeaderText, is(Texts.ABOUT_RENT_PAGE_HEADER_TEXT));
        if (actualHeaderText.equals(Texts.ABOUT_RENT_PAGE_HEADER_TEXT)) {
            System.out.println("PASSED: Текст заголовка корректен: " + actualHeaderText);
        } else {
            System.out.println("FAILED: Текст заголовка некорректен. Ожидалось: " + Texts.ABOUT_RENT_PAGE_HEADER_TEXT + ", но найдено: " + actualHeaderText);
        }


//        Когда привезти самокат
        objAboutRentOrderPage.clickRentDateInput();
        if (pickDate.equals("17.03.2025")) {
            objAboutRentOrderPage.clickPickDate();
        } else if (pickDate.equals("18.03.2025")) {
            objAboutRentOrderPage.clickPickDate2();
        }

        objAboutRentOrderPage.getRentDateValue();
        String actualRentDateValue = objAboutRentOrderPage.getRentDateValue();
        MatcherAssert.assertThat(actualRentDateValue, is(pickDate));

        if (actualRentDateValue.equals(pickDate)) {
            System.out.println("PASSED: Дата заказа корректена: " + actualRentDateValue);
        } else {
            System.out.println("FAILED: Дата заказа некорректена. Ожидалось: " + pickDate + ", но найдено: " + actualRentDateValue);
        }


        //        срок аренды
        objAboutRentOrderPage.clickRentTimeInput();
        if (pickTime.equals("сутки")) {
            objAboutRentOrderPage.clickPickTime();
        } else if (pickTime.equals("трое суток")) {
            objAboutRentOrderPage.clickPickTime2();
        }

        objAboutRentOrderPage.getPickTimeText();
        String actualPickTimeText = objAboutRentOrderPage.getPickTimeText();
        MatcherAssert.assertThat(actualPickTimeText, is(pickTime));

        if (actualPickTimeText.equals(pickTime)) {
            System.out.println("PASSED: срок аренды корректен: " + actualPickTimeText);
        } else {
            System.out.println("FAILED: срок аренды некорректен. Ожидалось: " + pickTime + ", но найдено: " + actualPickTimeText);
        }


        //        цвет самоката
        // Выбор чекбокса в зависимости от входного параметра
        if (colorCheckBox.equals("чёрный жемчуг")) {
            objAboutRentOrderPage.clickBlackColorCheckBox();
        } else if (colorCheckBox.equals("серая безысходность")) {
            objAboutRentOrderPage.clickGreyColorCheckBox();
        }

        // Проверка состояния чекбоксов
        if (objAboutRentOrderPage.isBlackColorCheckBoxSelected()) {
            System.out.println("Чекбокс 'чёрный жемчуг' выбран.");
        } else {
            System.out.println("Чекбокс 'чёрный жемчуг' не выбран.");
        }

        if (objAboutRentOrderPage.isGreyColorCheckBoxSelected()) {
            System.out.println("Чекбокс 'серая безысходность' выбран.");
        } else {
            System.out.println("Чекбокс 'серая безысходность' не выбран.");
        }

        // Получение фактического текста цвета
        String actualColorText = objAboutRentOrderPage.getColorValue();
        MatcherAssert.assertThat(actualColorText, is(colorCheckBox));

        // Проверка корректности текста
        if (actualColorText.equals(colorCheckBox)) {
            System.out.println("PASSED: Цвет самоката корректен: " + actualColorText);
        } else {
            System.out.println("FAILED: Цвет самоката некорректен. Ожидалось: " + colorCheckBox + ", но найдено: " + actualColorText);
        }


        //       Комментарий
        objAboutRentOrderPage.emptyCommentInput(commentInput);
        objAboutRentOrderPage.getCommentValue();

        String actualCommentValue = objAboutRentOrderPage.getCommentValue();
        MatcherAssert.assertThat(actualCommentValue, is(commentInput));

        if (actualCommentValue.equals(commentInput)) {
            System.out.println("PASSED: Комментарий корректен: " + actualCommentValue);
        } else {
            System.out.println("FAILED: Комментарий некорректен. Ожидалось: " + commentInput + ", но найдено: " + actualCommentValue);
        }


        //       Кнопка Заказать
        objAboutRentOrderPage.clickOrderButton();


        //         Стр Хотите оформить заказ?
        objAboutRentOrderPage.isOrderConfirmationHeader();

        objAboutRentOrderPage.getOrderConfirmationHeader();
        String actualConfirmHeaderText = objAboutRentOrderPage.getOrderConfirmationHeader();
        MatcherAssert.assertThat(actualConfirmHeaderText, is(Texts.PLACE_ORDER_TEXT));

        if (actualConfirmHeaderText.equals(Texts.PLACE_ORDER_TEXT)) {
            System.out.println("PASSED: Заголовок Подтвержления корректен: " + actualConfirmHeaderText);
        } else {
            System.out.println("FAILED: Заголовок Подтвержления  некорректен. Ожидалось: " + Texts.PLACE_ORDER_TEXT + ", но найдено: " + actualConfirmHeaderText);
        }


//         Кнопка ДА
        objAboutRentOrderPage.clickConfirmOrderButton();

        try {
            // Получаем текст заголовка
            String actualConfirmationMessageHeaderText = objAboutRentOrderPage.getOrderPlacedHeaderText();

            // Проверяем, что текст заголовка соответствует ожидаемому
            MatcherAssert.assertThat(actualConfirmationMessageHeaderText, is(Texts.ORDER_PLACED_TEXT));

            // Если текст корректен
            System.out.println("PASSED: кнопка ДА нажата, отображается стр : " + actualConfirmationMessageHeaderText);
        } catch (NoSuchElementException e) {
            // Если локатор не найден или текст не появился
            System.out.println("FAILED: кнопка ДА нажата Заголовок " +  Texts.ORDER_PLACED_TEXT + " не появился");
            throw e; // Повторно выбрасываем исключение, чтобы тест завершился с ошибкой
        } catch (AssertionError e) {
            // Если текст некорректен
            System.out.println("FAILED: Заголовок подтверждения некорректен. Ожидалось: " + Texts.ORDER_PLACED_TEXT + ", но найдено: " + e.getMessage());
            throw e; // Повторно выбрасываем исключение, чтобы тест завершился с ошибкой
        }


        //       стр Заказ Оформлен
        objAboutRentOrderPage.getOrderPlacedHeaderText();
        String actualConfirmationMessageHeaderText = objAboutRentOrderPage.getOrderPlacedHeaderText();
        MatcherAssert.assertThat(actualConfirmationMessageHeaderText, is(Texts.ORDER_PLACED_TEXT));

        if (actualConfirmationMessageHeaderText.equals(Texts.ORDER_PLACED_TEXT)) {
            System.out.println("PASSED: Заголовок Подтвержления корректен: " + actualConfirmationMessageHeaderText);
        } else {
            System.out.println("FAILED: Заголовок Подтвержления  некорректен. Ожидалось: " + Texts.ORDER_PLACED_TEXT + ", но найдено: " + actualConfirmationMessageHeaderText);
        }

//         Кнопка Посмотреть Стаутс
        objAboutRentOrderPage.clickCheckStatusButton();


        //         Проверка загрузки стр информации о заказе с кнопкой отменить заказ
        objAboutRentOrderPage.getCancelOrderButtonText();

        String actualCancelOrderButtonText = objAboutRentOrderPage.getCancelOrderButtonText();
        MatcherAssert.assertThat(actualCancelOrderButtonText, is(Texts.CANCEL_ORDER_BUTTON_TEXT));

        if (actualCancelOrderButtonText.equals(Texts.CANCEL_ORDER_BUTTON_TEXT)) {
            System.out.println("PASSED: отображается стр просмотра заказ, можно : " + actualCancelOrderButtonText);
        } else {
            System.out.println("FAILED: не отображается стр просмотра заказ, нет кнопки: " + actualCancelOrderButtonText);
        }

    }

    @After
    public void tearDown() {
        BrowserUtils.closeBrowser(driver);
    }
}

