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
        String operativeSystem = System.getProperty("os.name").toLowerCase();

        switch (browserType) {
            case CHROME:
                if (operativeSystem.contains("win")) {
                    System.setProperty("webdriver.chrome.driver", "src/test/java/core/WebDrivers/chromedriver.exe");
                } else if (operativeSystem.contains("nix") || operativeSystem.contains("nux")) {
                    System.setProperty("webdriver.chrome.driver", "src/test/java/core/WebDrivers/chromedriverx");
                }
                driver = new ChromeDriver(getChromeOptions());
                break;
            case FIREFOX:
                if (operativeSystem.contains("win")) {
                    System.setProperty("webdriver.firefox.driver", "src/test/java/core/WebDrivers/geckodriver.exe");
                } else if (operativeSystem.contains("nix") || operativeSystem.contains("nux")) {
                    System.setProperty("webdriver.firefox.driver", "src/test/java/core/WebDrivers/geckodriverx");
                }
                driver = new FirefoxDriver(getFirefoxOptions());
                break;
            case EDGE:
                if (operativeSystem.contains("win")) {
                    System.setProperty("webdriver.edge.driver", "src/test/java/core/WebDrivers/msedgedriver.exe");
                } else if (operativeSystem.contains("nix") || operativeSystem.contains("nux")) {
                    System.setProperty("webdriver.edge.driver", "src/test/java/core/WebDrivers/msedgedriverx");
                }
                driver = new EdgeDriver(getEdgeOptions());
                break;
        }
        return driver;
    }

    ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        if (HEADLESS) {
            chromeOptions.addArguments("--headless=new");
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--disable-dev-shm-usage");
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
        edgeOptions.addArguments("--remote-allow-origins=*");
        if (HEADLESS) edgeOptions.addArguments("--headless");
        return edgeOptions;
    }

    public enum BrowserList {
        CHROME, FIREFOX, EDGE
    }
}
