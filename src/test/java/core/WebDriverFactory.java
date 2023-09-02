package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static core.FrameworkConfig.HEADLESS;

public class WebDriverFactory {
    public WebDriver createInstance(String browser) {
        WebDriver driver = null;
        BrowserList browserType = BrowserList.valueOf(browser.toUpperCase());

        switch (browserType) {
            case CHROME:
                driver = new ChromeDriver(getChromeOptions());
                break;
            case FIREFOX:
                driver = new FirefoxDriver(getFirefoxOptions());
                break;
            case EDGE:
                driver = new EdgeDriver(getEdgeOptions());
                break;
        }
        return driver;
    }

    ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        if (HEADLESS) {
            chromeOptions.addArguments("--headless=new");
        }
        return chromeOptions;
    }

    FirefoxOptions getFirefoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        if (HEADLESS) firefoxOptions.addArguments("--headless");
        return firefoxOptions;
    }

    EdgeOptions getEdgeOptions() {
        EdgeOptions edgeOptions = new EdgeOptions();
        if (HEADLESS) edgeOptions.addArguments("--headless");
        return edgeOptions;
    }

    public enum BrowserList {
        CHROME, FIREFOX, EDGE
    }
}
