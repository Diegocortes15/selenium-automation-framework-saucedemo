package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

import static core.App.HEADLESS;

public class WebDriverFactory {
    public WebDriver createInstance(String browser) {
        WebDriver driver = null;
        BrowserList browserType = BrowserList.valueOf(browser.toUpperCase());

        switch (browserType) {
            case CHROME:
                if (Objects.equals(App.PLATFORM, "local")) {
                    driver = new ChromeDriver(getChromeOptions());
                } else if (Objects.equals(App.PLATFORM, "remote")) {
                    try {
                        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), getChromeOptions());
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case FIREFOX:
                if (Objects.equals(App.PLATFORM, "local")) {
                    driver = new FirefoxDriver(getFirefoxOptions());
                } else if (Objects.equals(App.PLATFORM, "remote")) {
                    try {
                        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), getFirefoxOptions());
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case EDGE:
                if (Objects.equals(App.PLATFORM, "local")) {
                    driver = new EdgeDriver(getEdgeOptions());
                } else if (Objects.equals(App.PLATFORM, "remote")) {
                    try {
                        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), getEdgeOptions());
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                }
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
