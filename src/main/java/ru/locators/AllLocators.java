package ru.locators;

import org.openqa.selenium.By;

public class AllLocators {
    // Заголовок главной страницы
    public static final By MAIN_HEADER = By.xpath(".//div[@class='Home_Header__iJKdX']");
    // Раздел "Вопросы о важном"
    public static final By SUB_HEADER = By.className("Home_SubHeader__zwi_E");
    // Кнопка Аккардеона 1
    public static final By ACCORDION_BUTTON = By.id("accordion__heading-0");
    // Текст Аккардеона 1
    public static final By ACCORDION_PANEL = By.id("accordion__panel-0");
    // Кнопка "Заказать" Хедер
    public static final By ORDER_BUTTON_HEADER = By.className("Button_Button__ra12g");
    // Кнопка "Заказать" Миддл
    public static final By ORDER_BUTTON_MIDDLE = By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div[5]/button");


    // Заголовок страницы оформления заказа Информация о клиенте
    public static final By ORDER_PAGE_HEADER = By.className("Order_Header__BZXOb");
    // Инпут Имя страницы оформления заказа
    public static final By NAME_INPUT = By.xpath(".//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/input");
    // Инпут Фамилия страницы оформления заказа
    public static final By SURNAME_INPUT = By.xpath(".//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/input");
    // Инпут Адрес страницы оформления заказа
    public static final By ADRESS_INPUT = By.xpath(".//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/input");
    // Станция метро "Красносельская" страницы оформления заказа
    public static final By STATION_KRASNOSELSKAYA = By.xpath(".//div[contains(@class, 'select-search__select')]//*[contains(text(), 'Красносельская') or contains(@value, 'Красносельская') or contains(@data-value, 'Красносельская')]");
    // Станция метро "Лубянка" страницы оформления заказа
    public static final By STATION_LYBIANKA = By.xpath(".//div[contains(@class, 'select-search__select')]//*[contains(text(), 'Лубянка') or contains(@value, 'Лубянка') or contains(@data-value, 'Лубянка')]");
    // Поле Станция метро страницы оформления заказа
    public static final By METRO_SELECTOR = By.className("select-search__input");
    // Список Станциq метро
    public static final By METRO_LIST = By.className("select-search__select");
    // Селектор Станция метро заполнен
    public static final By METRO_SELECTOR_FILLED =By.xpath("//input[contains(@class, 'select-search__input') and contains(@value, 'Красносельская')]");
    // Инпут Телефон метро страницы оформления заказа
    public static final By PHONE_INPUT = By.xpath(".//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/input");
    // Кнопка Далее страницы оформления заказа
    public static final By NEXT_BUTTON = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");


    // Заголовок страницы оформления заказа про Аренду
    public static final By RENT_PAGE_HEADER = By.className("Order_Header__BZXOb");
    // Инпут Когда привезти самокат
    public static final By RENT_DATE_INPUT = By.xpath(".//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div/input");
    // Инпут Когда привезти самокат
    public static final By RENT_TIME_INPUT = By.className("Dropdown-placeholder");
    // Селектор Срок Аренды 17 число
    public static final By RENT_DATE_SELECTOR = By.xpath(".//div[contains(@class, 'react-datepicker__day') and contains(text(), '17') and contains(@aria-label, 'марта 2025')]");
    // Селектор Срок Аренды 18 число
    public static final By RENT_DATE_SELECTOR2 = By.xpath(".//div[contains(@class, 'react-datepicker__day') and contains(text(), '18') and contains(@aria-label, 'марта 2025')]");
    // поле выбора времени аренды сутки
    public static final By RENT_TIME = By.xpath(".//div[contains(@class, 'Dropdown-option') and contains(text(), 'сутки')]");
    // поле выбора времени аренды трое суток
    public static final By RENT_TIME2 = By.xpath(".//div[contains(@class, 'Dropdown-option') and contains(text(), 'трое суток')]");


    // Чекбокс "черный жемчуг"
    public static final By CHECK_BOX_COLOR_BLACK = By.xpath(".//label[contains(text(), 'чёрный жемчуг')]/input");
    // Чекбокс "серая безысходность"
    public static final By CHECK_BOX_COLOR_GREY = By.xpath(".//label[contains(text(), 'серая безысходность')]/input");
    // Инпут Комментарий
    public static final By COMMENT_INPUT = By.xpath(".//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/input");
    // Кнопка Заказать
    public static final By ORDER_BUTTON = By.xpath(".//*[@id=\"root\"]/div/div[2]/div[3]/button[2]");


    // Хедер поп ап подтвержлеия заказ
    public static final By ORDER_CONFIRMATION_HEADER = By.xpath(".//*[@id=\"root\"]/div/div[2]/div[5]/div[1]");
    // Кнопка подтвердения заказ
    public static final By ORDER_CONFIRMATION_BUTTON = By.xpath(".//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[2]");
    // Текст подтвержлеия заказ
    public static final By ORDER_CONFIRMATION_TEXT = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");
    // Кнопка проверить статус заказа
    public static final By CHECK_SATSTUS_BUTTON = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button[text()='Посмотреть статус']");





}



