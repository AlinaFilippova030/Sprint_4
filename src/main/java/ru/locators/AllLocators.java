package ru.locators;

import org.openqa.selenium.By;

public class AllLocators {
    // Заголовок главной страницы
    public static final By MAIN_HEADER = By.xpath(".//div[@class='Home_Header__iJKdX']");
    // Раздел "Вопросы о важном"
    public static final By SUB_HEADER = By.xpath(".//div/div/div[5]/div[1]");
    // Кнопка Аккардеона 1
    public static final By ACCORDION_BUTTON = By.xpath(".//div[@class='accordion__button']");
    // Текст Аккардеона 1
    public static final By ACCORDION_PANEL = By.xpath(".//div[@id='accordion__panel-0']");
    // Кнопка "Заказать" Хедер
    public static final By ORDER_BUTTON_HEADER = By.xpath(".//div/button[@class='Button_Button__ra12g']");
    // Кнопка "Заказать" Миддл
    public static final By ORDER_BUTTON_MIDDLE = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");


    // Заголовок страницы оформления заказа Информация о клиенте
    public static final By ORDER_PAGE_HEADER = By.xpath(".//div[@class='Order_Header__BZXOb']");
    // Инпут Имя страницы оформления заказа
    public static final By NAME_INPUT = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']");
    // Имя Клиента Значение
    public static final By CLIENT_NAME = By.xpath(".//div[@class='Order_Form__17u6u']//input[@placeholder='* Имя']");
    // Инпут Фамилия страницы оформления заказа
    public static final By SURNAME_INPUT = By.xpath(".//div[2]/div[2]/div[2]/input");
    // Фамилия Клиента Значение
    public static final By CLIENT_SURNAME = By.xpath(".//div[@class='Order_Form__17u6u']//input[@placeholder='* Фамилия']");
    // Инпут Адрес страницы оформления заказа
    public static final By ADRESS_INPUT = By.xpath(".//div[2]/div[2]/div[3]/input");
    // Адресс Клиента Значение
    public static final By CLIENT_ADRESS_VALUE = By.xpath(".//div[@class='Order_Form__17u6u']//input[@placeholder='* Адрес: куда привезти заказ']");
    // Выбор "Красносельская" страницы оформления заказа
    public static final By STATION_KRASNOSELSKAYA = By.xpath(".//div[contains(@class, 'select-search__select')]//*[contains(text(), 'Красносельская') or contains(@value, 'Красносельская') or contains(@data-value, 'Красносельская')]");
    // Станция метро "Красносельская" Значение
    public static final By METRO_STATION_VALUE = By.xpath(".//div[@class='Order_Form__17u6u']//input[@placeholder='* Станция метро']");
    // Станция метро "Лубянка" страницы оформления заказа
    public static final By STATION_LYBIANKA = By.xpath(".//div[contains(@class, 'select-search__select')]//*[contains(text(), 'Лубянка') or contains(@value, 'Лубянка') or contains(@data-value, 'Лубянка')]");
    // Поле Станция метро страницы оформления заказа
    public static final By METRO_SELECTOR = By.xpath(".//div/input[@class='select-search__input']");
    // Список Станциq метро
    public static final By METRO_LIST = By.xpath(".//div[@class='select-search__select']");
    // Селектор Станция метро заполнен
    public static final By METRO_SELECTOR_FILLED = By.xpath("//input[contains(@class, 'select-search__input') and contains(@value, 'Красносельская')]");
    // Инпут Телефон страницы оформления заказа
    public static final By PHONE_INPUT = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    // Телефон Значение
    public static final By CLIENT_PHONE_VALUE = By.xpath(".//div[@class='Order_Form__17u6u']//input[@placeholder='* Телефон: на него позвонит курьер']");
    // Кнопка Далее страницы оформления заказа
    public static final By NEXT_BUTTON = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button[text()='Далее']");
    // Заголовок страницы оформления заказа про Аренду
    public static final By RENT_PAGE_HEADER = By.xpath(".//div[@class='Order_Content__bmtHS']/div[@class='Order_Header__BZXOb' and text()='Про аренду']");
    // Инпут Когда привезти самокат
    public static final By RENT_DATE_INPUT = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // Когда привезти самокат Значение
    public static final By RENT_DATE_VALUE = By.xpath(".//div[@class='Order_Form__17u6u']//input[@placeholder='* Когда привезти самокат']");
    // Инпут Срок Аренды
    public static final By RENT_TIME_INPUT = By.xpath(".//div[@class='Dropdown-placeholder' and text()='* Срок аренды']");
    // Селектор Срок Аренды 17 число
    public static final By RENT_DATE_SELECTOR = By.xpath(".//div[contains(@class, 'react-datepicker__day') and contains(text(), '17') and contains(@aria-label, 'марта 2025')]");
    // Селектор Срок Аренды 18 число
    public static final By RENT_DATE_SELECTOR2 = By.xpath(".//div[contains(@class, 'react-datepicker__day') and contains(text(), '18') and contains(@aria-label, 'марта 2025')]");
    // поле выбора времени аренды сутки
    public static final By RENT_TIME = By.xpath(".//div[contains(@class, 'Dropdown-option') and contains(text(), 'сутки')]");
    // поле выбора времени аренды трое суток
    public static final By RENT_TIME2 = By.xpath(".//div[contains(@class, 'Dropdown-option') and contains(text(), 'трое суток')]");
    // Срок аренды Значение сутки
    public static final By RENT_TIME_VALUE = By.xpath(".//div[contains(@class, 'Dropdown-placeholder') and contains(@class, 'is-selected')]");
    // Локатор для чекбокса "чёрный жемчуг"
    public static final By CHECK_BOX_COLOR_BLACK_CHECKED = By.xpath(".//input[@id='black']");
    // Локатор для чекбокса "серая безысходность"
    public static final By CHECK_BOX_COLOR_GREY_CHECKED = By.xpath(".//input[@id='grey']");
    // Локатор для текста чекбокса "чёрный жемчуг"
    public static final By CHECK_BOX_COLOR_BLACK_TEXT = By.xpath(".//label[@for='black']");
    // Локатор для текста чекбокса "серая безысходность"
    public static final By CHECK_BOX_COLOR_GREY_TEXT = By.xpath(".//label[@for='grey']");
    // Локатор для текста цвета
    public static final By COLOR_VALUE = By.xpath(".//label[@for='black' or @for='grey']");
    // Инпут Комментарий
    public static final By COMMENT_INPUT = By.xpath(".//input[contains(@class, 'Input_Input__1iN_Z') and @placeholder='Комментарий для курьера']");
    //  Комментарий Значение
    public static final By COMMENT_VALUE = By.xpath(".//div[@class='Input_InputContainer__3NykH']//input[@placeholder='Комментарий для курьера']");
    // Кнопка Заказать
    public static final By ORDER_BUTTON = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    // Хедер Хотите оформить заказ?
    public static final By ORDER_CONFIRMATION_HEADER = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and contains(text(), 'Хотите оформить заказ?')]");


    // Кнопка Да подтверждения заказ
    public static final By ORDER_CONFIRMATION_BUTTON = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");
    // Текст подтвержлеия заказ
    public static final By ORDER_CONFIRMATION_TEXT = By.xpath(".//div[contains(@class, 'Order_ModalHeader__3FDaJ') and contains(text(), 'Заказ оформлен')]");


    public static final By ORDER_PLACED_HEADER_TEXT = By.xpath(".//div[contains(@class, 'Order_ModalHeader__3FDaJ') and contains(text(), 'Заказ оформлен')]");
    // Кнопка Посмотреть статус
    public static final By CHECK_SATSTUS_BUTTON = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button[text()='Посмотреть статус']");
    // Кнопка Отменить заказ
    public static final By CANCEL_ORDER_BUTTON = By.xpath(".//button[contains(@class, 'Button_Button__ra12g') and contains(@class, 'Button_Middle__1CSJM') and contains(@class, 'Button_Inverted__3IF-i') and text()='Отменить заказ']");

}

