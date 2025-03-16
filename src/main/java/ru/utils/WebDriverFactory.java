package ru.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFactory {

    public static WebDriver createDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "geckodriver"); // Укажите путь к geckodriver
                FirefoxOptions options = new FirefoxOptions();
                options.setBinary("/Applications/Firefox.app/Contents/MacOS/firefox"); // Путь к Firefox на macOS
                return new FirefoxDriver(options);
            case "chrome":
            default:
                String driverPath = "chromedriver";
                System.setProperty("webdriver.chrome.driver", driverPath);// Укажите путь к chromedriver
                return new ChromeDriver();
        }
    }
}