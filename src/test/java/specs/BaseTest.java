package specs;

import core.LoggerLoad;
import core.WebDriverFactory;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public abstract class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    @Description("Browser start up")
    @Step("⏯ Browser start up - {0}")
    @Parameters("browser")
    public void setDriver(String browser) {

        LoggerLoad.info("Browser start up - " + browser);
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/test/java/core/drivers/chromedriver.exe");
            driver = new WebDriverFactory().createInstance(browser);
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "src/test/java/core/drivers/msedgedriver.exe");
            driver = new WebDriverFactory().createInstance(browser);
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/test/java/core/drivers/geckodriver.exe");
            driver = new WebDriverFactory().createInstance(browser);
        }

        driver.manage().window().maximize();
        //driver.navigate().to(Constants.SUT);
    }

    @AfterMethod
    @Description("Browser tear down")
    @Step("🔚 Browser tear down")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        LoggerLoad.info("Browser tear down");
    }

    public WebDriver getDriver() {
        return driver;
    }
}

