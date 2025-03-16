package ru.home.page.test;

import ru.pages.HomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.config.Config;

import static org.hamcrest.CoreMatchers.is;
import org.hamcrest.MatcherAssert;
import ru.texts.Texts;
import ru.utils.WebDriverFactory;

public class FqaSectionTest {
    private WebDriver driver;



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
        objHomePage.clickAccordionItemButton();
        String actualTextInAccordion = objHomePage.textInAccardeon();
        MatcherAssert.assertThat(actualTextInAccordion, is(Texts.ACCORDION_ITEM_PANEL_TEXT));
        if (actualTextInAccordion.equals(Texts.ACCORDION_ITEM_PANEL_TEXT)) {
            System.out.println("PASSED: Текст заголовка корректен: " + actualTextInAccordion);
        } else {
            System.out.println("FAILED: Текст заголовка некорректен. Ожидалось: " + Texts.ACCORDION_ITEM_PANEL_TEXT + ", но найдено: " + actualTextInAccordion);
        }

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}