package ru.home.page.test;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.pages.HomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.config.Config;
import static org.hamcrest.CoreMatchers.is;
import org.hamcrest.MatcherAssert;
import ru.utils.WebDriverFactory;
import ru.utils.BrowserUtils;


@RunWith(Parameterized.class)
public class FaqSectionTest {
    private WebDriver driver;

    // Параметры
    private final int idNumber;
    private final String questionButton;
    private final String answerPanel;

    // Конструктор для параметров
    public FaqSectionTest(int idNumber, String questionButton, String answerPanel) {
        this.idNumber = idNumber;
        this.questionButton = questionButton;
        this.answerPanel = answerPanel;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[] [] getTestData() {
        return new Object[] []{
                {0, "Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, "Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, "Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, "Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5, "Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, "Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7, "Я жизу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @Before
    public void setUp() {
        String browser = Config.getBrowser(); // Получаем значение из файла config.properties
        driver = WebDriverFactory.createDriver(browser); // Создаем драйвер через фабрику
        driver.manage().window().maximize();
    }

    @Test
    public void CheckTextInAccardeonTest() {
        HomePage objHomePage = new HomePage(driver);
        objHomePage.isHomePageLoaded();
        objHomePage.scrollToSubHeader();

        // Нажимаем на кнопку аккордеона по номеру
        objHomePage.clickAccordionItemButton(idNumber);
        String actualAccordionButtonText = objHomePage.getAccordionButtonText(idNumber);
        MatcherAssert.assertThat(actualAccordionButtonText, is(questionButton));
        if (actualAccordionButtonText.equals(questionButton)) {
            System.out.println("PASSED: Текст аккордеона " + idNumber + " корректен: " + actualAccordionButtonText);
        } else {
            System.out.println("FAILED: Текст аккордеона " + idNumber + " некорректен. Ожидалось: " + answerPanel + ", но найдено: " + actualAccordionButtonText);
        }
        // Получаем текст аккордеона
        String actualTextInAccordion = objHomePage.textInAccordion(idNumber);
        // Проверяем, что текст соответствует ожидаемому
        MatcherAssert.assertThat(actualTextInAccordion, is(answerPanel));
        if (actualTextInAccordion.equals(answerPanel)) {
            System.out.println("PASSED: Текст в аккордеоне " + idNumber + " корректен: " + actualTextInAccordion);
        } else {
            System.out.println("FAILED: Текст в аккордеоне " + idNumber + " некорректен. Ожидалось: " + answerPanel + ", но найдено: " + actualTextInAccordion);
        }
    }

    @After
    public void tearDown() {
        BrowserUtils.closeBrowser(driver);
    }
}