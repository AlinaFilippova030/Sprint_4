package ru.home.page.test;

import ru.config.Config;
import ru.texts.Texts;
import org.hamcrest.MatcherAssert;
import ru.pages.HomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.utils.BrowserUtils;
import ru.utils.WebDriverFactory;

import static org.hamcrest.CoreMatchers.is;


public class HomePageLoadTest {
    private WebDriver driver;


    @Before
    public void setUp() {
        String browser = Config.getBrowser(); // Получаем значение из файла config.properties
        driver = WebDriverFactory.createDriver(browser); // Создаем драйвер через фабрику
        driver.manage().window().maximize();
    }

    @Test
    public void CheckMainPageTextTest() {
        HomePage objHomePage = new HomePage(driver);
        objHomePage.isHomePageLoaded();

        String actualHeaderText = objHomePage.textInMainHeader();
        MatcherAssert.assertThat(actualHeaderText, is(Texts.MAIN_PAGE_HEADER_TEXT));
        if (actualHeaderText.equals(Texts.MAIN_PAGE_HEADER_TEXT)) {
            System.out.println("PASSED: Текст заголовка корректен: " + actualHeaderText);
        } else {
            System.out.println("FAILED: Текст заголовка некорректен. Ожидалось: " + Texts.MAIN_PAGE_HEADER_TEXT + ", но найдено: " + actualHeaderText);
        }

    }

    @After
    public void tearDown() {
        BrowserUtils.closeBrowser(driver);
    }
}