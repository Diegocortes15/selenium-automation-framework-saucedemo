package pages;

import core.FrameworkConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    private final String url = FrameworkConfig.BASE_URL;

    @FindBy(id = "user-name")
    private WebElement inputUser;

    @FindBy(id = "password")
    private WebElement inputPassword;

    @FindBy(id = "login-button")
    private WebElement buttonSubmit;

    @FindBy(css = ".error-message-container.error")
    private WebElement errorMessage;

    @FindBy(className = "login_logo")
    private WebElement loginLogo;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void goTo() {
        driver.navigate().to(this.url);
    }

    public void waitUntilLogoBeVisible() {
        seleniumFactory.waitElementUntil(loginLogo, "VISIBLE");
    }

    public void enterUsername(String username) {
        seleniumFactory.sendKeys(inputUser, username);
    }

    public void enterPassword(String password) {
        seleniumFactory.sendKeys(inputPassword, password);
    }

    public void verifyUsername(String expectedUsername) {
        seleniumFactory.verifyValue(inputUser, expectedUsername);
    }

    public void verifyPassword(String expectedPassword) {
        seleniumFactory.verifyValue(inputPassword, expectedPassword);
    }

    public ProductsPage clickButtonSubmit() {
        seleniumFactory.click(buttonSubmit);
        return new ProductsPage(driver);
    }

    public ProductsPage login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        seleniumFactory.embedFullPageScreenshot("Login with \"" + username + "\" username - Screenshot");
        return clickButtonSubmit();
    }

    public void verifyValidationMessage(String validationMessage) {
        seleniumFactory.verifyText(errorMessage, validationMessage);
    }

    public void verifyLoginURL() {
        waitUntilLogoBeVisible();
        seleniumFactory.verifyURLToBe(this.url);
    }
}
