package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    public WebDriver createInstance(String browser) {
        WebDriver driver = null;
        BrowserList browserType = BrowserList.valueOf(browser.toUpperCase());


        switch (browserType) {
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                System.setProperty("webdriver.chrome.driver", "src/test/java/core/WebDrivers/chromedriver.exe");
                driver = new ChromeDriver(chromeOptions);
                break;
            case FIREFOX:
                System.setProperty("webdriver.firefox.driver", "src/test/java/core/WebDrivers/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case EDGE:
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                System.setProperty("webdriver.edge.driver", "src/test/java/core/WebDrivers/msedgedriver.exe");
                driver = new EdgeDriver(edgeOptions);
                break;
        }
        return driver;
    }

    public enum BrowserList {
        CHROME, FIREFOX, EDGE
    }
}
