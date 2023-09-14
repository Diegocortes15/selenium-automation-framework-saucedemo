package pages;

import core.App;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    private final String url = App.BASE_URL;

    @FindBy(id = "user-name")
    private WebElement inputUser;

    @FindBy(id = "password")
    private WebElement inputPassword;

    @FindBy(id = "login-button")
    private WebElement buttonSubmit;

    @FindBy(css = ".error-message-container.error")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("⏩ Go to " + url)
    public void goTo() {
        driver.navigate().to(this.url);
    }

    @Step("⏩ Enter username: \"{0}\"")
    public void enterUsername(String username) {
        seleniumFactory.sendKeys(inputUser, username);
    }

    @Step("⏩ Enter password")
    public void enterPassword(String password) {
        seleniumFactory.sendKeys(inputPassword, password);
    }

    @Step("🧪 Verify username: \"{0}\"")
    public void verifyUsername(String expectedUsername) {
        seleniumFactory.verifyValue(inputUser, expectedUsername);
    }

    @Step("🧪 Verify password")
    public void verifyPassword(String expectedPassword) {
        seleniumFactory.verifyValue(inputPassword, expectedPassword);
    }

    @Step("⏩ Click on submit button")
    public ProductsPage clickButtonSubmit() {
        seleniumFactory.click(buttonSubmit);
        return new ProductsPage(driver);
    }

    @Step("⏩ Login with username: \"{0}\"")
    public ProductsPage login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        seleniumFactory.embedFullPageScreenshot("Login with \"" + username + "\" username - Screenshot");
        return clickButtonSubmit();
    }

    @Step("🧪 Verify validation message: \"{0}\"")
    public void verifyValidationMessage(String validationMessage) {
        seleniumFactory.verifyText(errorMessage, validationMessage);
    }

    @Step("🧪 Verify URL:" + url)
    public void verifyLoginURL() {
        seleniumFactory.verifyURLToBe(this.url);
    }
}
