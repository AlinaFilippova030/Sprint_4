package ru.home.page.test;

import ru.pages.HomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class HomePageLoadTest {
    private WebDriver driver;

    @Before
    public void setup() {
//              CHROME DRIVER
        String driverPath = "chromedriver";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
    }

//  //            FIREFOX DRIVER
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
//}

    @Test
    public void CheckMainPageText() {
        HomePage objHomePage = new HomePage(driver);
        objHomePage.isHomePageLoaded();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}