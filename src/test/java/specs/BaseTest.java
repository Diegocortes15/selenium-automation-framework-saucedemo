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
        driver = new WebDriverFactory().createInstance(browser);
        driver.manage().window().maximize();
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

