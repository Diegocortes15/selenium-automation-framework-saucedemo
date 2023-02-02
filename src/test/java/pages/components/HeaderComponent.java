package pages.components;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.CartPage;

public class HeaderComponent extends BasePage {

    @FindBy(className = "bm-burger-button")
    private WebElement burgerButton;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutButton;

    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCartButton;

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    @Step("⏩ Click on burger button")
    public void clickBurgerButton() {
        seleniumFactory.click(burgerButton);
    }

    @Step("⏩ Click on logout button")
    public void clickLogoutButton() {
        seleniumFactory.click(logoutButton);
    }

    @Step("⏩ Click on shopping cart button")
    public CartPage clickShoppingCartButton() {
        seleniumFactory.click(shoppingCartButton);
        return new CartPage(driver);
    }

    @Step("⏩ Click on logout")
    public void logout() {
        clickBurgerButton();
        clickLogoutButton();
    }
}
