package pages.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class HeaderComponent extends BasePage {

    @FindBy(className = "bm-burger-button")
    private WebElement burgerButton;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutButton;

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public void clickBurgerButton() {
        seleniumFactory.click(burgerButton);
    }

    public void clickLogoutButton() {
        seleniumFactory.click(logoutButton);

    }

    public void logout() {
        clickBurgerButton();
        clickLogoutButton();
    }
}
