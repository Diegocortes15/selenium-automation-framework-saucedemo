package pages;

import core.LoggerLoad;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.ByteArrayInputStream;
import java.util.Objects;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("📸 {0} - 📸 Full page screenshot")
    public void embedFullPageScreenshot(String description) {
        Allure.addAttachment("📸 " + description + " - 📸 Full page screenshot", new ByteArrayInputStream(((TakesScreenshot) this.driver).getScreenshotAs(OutputType.BYTES)));
    }

    @Step("⏩ \"{0}\" Element is clicked")
    public void click(WebElement webElement) {
        webElement.click();
        LoggerLoad.info(webElement + " Element is clicked");
    }

    @Step("⏩ \"{0}\" is entered with \"{1}\"")
    public void sendKeys(WebElement webElement, String strValue) {
        webElement.sendKeys(strValue);
        LoggerLoad.info(webElement + " is entered with " + strValue);
    }

    @Step("⏩ \"{0}\" is selected with option \"{1}\"")
    public void selectByVisibleText(WebElement webElement, String strValue) {
        Select dropdown = new Select(webElement);
        dropdown.selectByVisibleText(strValue);
        LoggerLoad.info(webElement + " is selected with option " + strValue);
    }

    @Step("⏩ Getting \"{0}\" element text")
    public String getText(WebElement webElement) {
        LoggerLoad.info("⏩ Getting " + webElement + " element text");
        return webElement.getText();
    }

    @Step("🧪 Verifying if \"{0}\" value (\"{1}\") is displayed as expected {1}")
    public void verifyValue(WebElement webElement, String strExpectedValue) {
        String actualValue = webElement.getAttribute("value");
        if (Objects.equals(actualValue, strExpectedValue)) {
            Allure.addAttachment("✅ " + webElement + " value is displayed as Expected = " + strExpectedValue + " ; Actual = " + actualValue, "✅ " + webElement + " value is displayed as Expected = " + strExpectedValue + " ; Actual = " + actualValue);
            this.embedFullPageScreenshot("✅ " + webElement + " value is displayed as Expected = " + strExpectedValue + " ; Actual = " + actualValue);
            LoggerLoad.info("✅ " + webElement + " value is displayed as Expected = " + strExpectedValue + " ; Actual = " + actualValue);
        } else {
            Allure.addAttachment("💥 " + webElement + " value is NOT displayed as Expected = " + strExpectedValue + " ; Actual = " + actualValue, "💥 " + webElement + " value is NOT displayed as Expected = " + strExpectedValue + " ; Actual = " + actualValue);
            this.embedFullPageScreenshot("💥 " + webElement + " value is NOT displayed as Expected = " + strExpectedValue + " ; Actual = " + actualValue);
            LoggerLoad.error("💥 " + webElement + " value is NOT displayed as Expected = " + strExpectedValue + " ; Actual = " + actualValue);
        }
        Assert.assertEquals(actualValue, strExpectedValue);
    }

    @Step("🧪 Verifying if \"{0}\" text (\"{1}\") is displayed as expected {1}")
    public void verifyText(WebElement webElement, String strExpectedValue) {
        String actualValue = webElement.getText();
        if (Objects.equals(actualValue, strExpectedValue)) {
            Allure.addAttachment("✅ " + webElement + " text is displayed as Expected = " + strExpectedValue + " ; Actual = " + actualValue, "✅ " + webElement + " text is displayed as Expected = " + strExpectedValue + " ; Actual = " + actualValue);
            this.embedFullPageScreenshot("✅ " + webElement + " text is displayed as Expected = " + strExpectedValue + " ; Actual = " + actualValue);
            LoggerLoad.info("✅ " + webElement + " text is displayed as Expected = " + strExpectedValue + " ; Actual = " + actualValue);
        } else {
            Allure.addAttachment("💥 " + webElement + " text is NOT displayed as Expected = " + strExpectedValue + " ; Actual = " + actualValue, "💥 " + webElement + " text is NOT displayed as Expected = " + strExpectedValue + " ; Actual = " + actualValue);
            this.embedFullPageScreenshot("💥 " + webElement + " text is NOT displayed as Expected = " + strExpectedValue + " ; Actual = " + actualValue);
            LoggerLoad.error("💥 " + webElement + " text is NOT displayed as Expected = " + strExpectedValue + " ; Actual = " + actualValue);
        }
        Assert.assertTrue(actualValue.contains(strExpectedValue));
    }
}
