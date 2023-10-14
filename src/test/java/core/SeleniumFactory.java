package core;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class SeleniumFactory {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Actions actions;

    public SeleniumFactory(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        this.wait = new WebDriverWait(driver, Duration.ofMillis(App.ELEMENT_TIMEOUT));
    }

    public void waitElementUntil(WebElement webElement, WaitType type) {
        actions.scrollToElement(webElement);
        switch (type) {
            case VISIBLE:
                wait.until(ExpectedConditions.visibilityOf(webElement));
                break;
            case CLICKABLE:
                wait.until(ExpectedConditions.elementToBeClickable(webElement));
                break;
        }
    }

    public void waitUntilURL(String url) {
        wait.until(ExpectedConditions.urlToBe(url));
    }

    @Step("📸 {0} - 📸 Full page screenshot")
    public void embedFullPageScreenshot(String description) {
        Allure.addAttachment("📸 " + description + " - 📸 Full page screenshot", new ByteArrayInputStream(((TakesScreenshot) this.driver).getScreenshotAs(OutputType.BYTES)));
    }

    @Step("🐾 \"{0}\" Element is clicked")
    public void click(WebElement webElement) {
        waitElementUntil(webElement, WaitType.VISIBLE);
        webElement.click();
        LoggerLoad.info(webElement + " Element is clicked");
    }

    @Step("🐾 Web element with index \"{1}\" is clicked")
    public void clickByIndex(List<WebElement> webElementList, int index) {
        WebElement element = webElementList.get(index);
        waitElementUntil(element, WaitType.CLICKABLE);
        webElementList.get(index).click();
        LoggerLoad.info(element + " Element is clicked");
    }

    @Step("🐾 \"{0}\" is entered with \"{1}\"")
    public void sendKeys(WebElement webElement, String strValue) {
        waitElementUntil(webElement, WaitType.CLICKABLE);
        webElement.sendKeys(strValue);
        LoggerLoad.info(webElement + " is entered with " + strValue);
    }

    @Step("🐾 \"{0}\" is selected with option \"{1}\"")
    public void selectByVisibleText(WebElement webElement, String strValue) {
        waitElementUntil(webElement, WaitType.CLICKABLE);
        Select dropdown = new Select(webElement);
        dropdown.selectByVisibleText(strValue);
        LoggerLoad.info(webElement + " is selected with option " + strValue);
    }

    @Step("🐾 Getting \"{0}\" element text")
    public String getText(WebElement webElement) {
        waitElementUntil(webElement, WaitType.VISIBLE);
        LoggerLoad.info("⏩ Getting " + webElement + " element text");
        return webElement.getText();
    }

    @Step("🐾 Web element text with index \"{1}\" is obtained")
    public String getTextByIndex(List<WebElement> webElementList, int index) {
        WebElement element = webElementList.get(index);
        waitElementUntil(element, WaitType.VISIBLE);
        LoggerLoad.info(element + " Element text is obtained");
        return this.getText(element);
    }

    @Step("🧪 Verifying if \"{0}\" value (\"{1}\") is displayed as expected {1}")
    public void verifyValue(WebElement webElement, String strExpectedValue) {
        waitElementUntil(webElement, WaitType.VISIBLE);
        String actualValue = webElement.getAttribute("value");
        if (Objects.equals(actualValue, strExpectedValue)) {
            Allure.addAttachment("✅ " + webElement + " value is displayed as Expected = " + strExpectedValue + " ; Actual = " + actualValue, "✅ " + webElement + " value is displayed as Expected = " + strExpectedValue + " ; Actual = " + actualValue);
            this.embedFullPageScreenshot("✅ " + webElement + " value is displayed as Expected = " + strExpectedValue + " ; Actual = " + actualValue);
            LoggerLoad.info("PASSED: " + webElement + " value is displayed as Expected = " + strExpectedValue + " ; Actual = " + actualValue);
        } else {
            Allure.addAttachment("💥 " + webElement + " value is NOT displayed as Expected = " + strExpectedValue + " ; Actual = " + actualValue, "💥 " + webElement + " value is NOT displayed as Expected = " + strExpectedValue + " ; Actual = " + actualValue);
            this.embedFullPageScreenshot("💥 " + webElement + " value is NOT displayed as Expected = " + strExpectedValue + " ; Actual = " + actualValue);
            LoggerLoad.error("FAILED: " + webElement + " value is NOT displayed as Expected = " + strExpectedValue + " ; Actual = " + actualValue);
        }
        Assert.assertEquals(actualValue, strExpectedValue);
    }

    @Step("🧪 Verifying if \"{0}\" text (\"{1}\") is displayed as expected {1}")
    public void verifyText(WebElement webElement, String strExpectedValue) {
        waitElementUntil(webElement, WaitType.VISIBLE);
        String actualValue = this.getText(webElement);
        if (actualValue.contains(strExpectedValue)) {
            Allure.addAttachment("✅ " + webElement + " text is displayed as Expected = " + strExpectedValue + " ; Actual = " + actualValue, "✅ " + webElement + " text is displayed as Expected = " + strExpectedValue + " ; Actual = " + actualValue);
            this.embedFullPageScreenshot("✅ " + webElement + " text is displayed as Expected = " + strExpectedValue + " ; Actual = " + actualValue);
            LoggerLoad.info("PASSED: " + webElement + " text is displayed as Expected = " + strExpectedValue + " ; Actual = " + actualValue);
        } else {
            Allure.addAttachment("💥 " + webElement + " text is NOT displayed as Expected = " + strExpectedValue + " ; Actual = " + actualValue, "💥 " + webElement + " text is NOT displayed as Expected = " + strExpectedValue + " ; Actual = " + actualValue);
            this.embedFullPageScreenshot("💥 " + webElement + " text is NOT displayed as Expected = " + strExpectedValue + " ; Actual = " + actualValue);
            LoggerLoad.error("FAILED: " + webElement + " text is NOT displayed as Expected = " + strExpectedValue + " ; Actual = " + actualValue);
        }
        Assert.assertTrue(actualValue.contains(strExpectedValue));
    }

    @Step("🧪 Verifying that the user is in the url \"{0}\"")
    public void verifyURLToBe(String expectURL) {
        this.waitUntilURL(expectURL);
        String actualURL = driver.getCurrentUrl();
        if (actualURL.equals(expectURL)) {
            Allure.addAttachment("✅ URL page is as Expected = " + expectURL + " ; Actual = " + actualURL, "✅ URL page is as Expected = " + expectURL + " ; Actual = " + actualURL);
            this.embedFullPageScreenshot("✅ URL page is as Expected = " + expectURL + " ; Actual = " + actualURL);
            LoggerLoad.info("PASSED: URL page is as Expected = " + expectURL + " ; Actual = " + actualURL);
        } else {
            Allure.addAttachment("💥 URL page is NOT as Expected = " + expectURL + " ; Actual = " + actualURL, "💥 URL page is NOT as Expected = " + expectURL + " ; Actual = " + actualURL);
            this.embedFullPageScreenshot("💥 URL page is NOT as Expected = " + expectURL + " ; Actual = " + actualURL);
            LoggerLoad.info("FAILED: URL page is NOT as Expected = " + expectURL + " ; Actual = " + actualURL);
        }
        Assert.assertEquals(actualURL, expectURL);
    }

    @Step("🧪 Verifying that \"{0}\" match with \"{1}\"")
    public void verifyCompareValues(String actualValue, String expectedValue) {
        if (Objects.equals(actualValue, expectedValue)) {
            Allure.addAttachment("✅ Value is displayed as Expected = " + expectedValue + " ; Actual = " + actualValue, "✅ Value is displayed as Expected = " + expectedValue + " ; Actual = " + actualValue);
            this.embedFullPageScreenshot("✅ Value is displayed as Expected = " + expectedValue + " ; Actual = " + actualValue);
            LoggerLoad.info("PASSED: Value is displayed as Expected = " + expectedValue + " ; Actual = " + actualValue);
        } else {
            Allure.addAttachment("💥 Value is NOT displayed as Expected = " + expectedValue + " ; Actual = " + actualValue, "💥 Value is NOT displayed as Expected = " + expectedValue + " ; Actual = " + actualValue);
            this.embedFullPageScreenshot("💥 Value is NOT displayed as Expected = " + expectedValue + " ; Actual = " + actualValue);
            LoggerLoad.info("FAILED: Value is displayed as Expected = " + expectedValue + " ; Actual = " + actualValue);
        }
        Assert.assertEquals(actualValue, expectedValue);
    }
}
