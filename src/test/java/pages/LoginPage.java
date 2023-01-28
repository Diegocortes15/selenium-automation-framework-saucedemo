package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

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

    public void goTo() {
        driver.navigate().to("https://www.saucedemo.com/");
    }

    public void enterUsername(String username) {
        sendKeys(inputUser, username);
    }

    public void enterPassword(String password) {
        sendKeys(inputPassword, password);
    }

    public void verifyUsername(String expectedUsername) {
        verifyValue(inputUser, expectedUsername);
    }

    public void verifyPassword(String expectedPassword) {
        verifyValue(inputPassword, expectedPassword);
    }

    public ProductsPage clickButtonSubmit() {
        click(buttonSubmit);
        return new ProductsPage(driver);
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        embedFullPageScreenshot("Login - Screenshot");
        clickButtonSubmit();
    }
}
