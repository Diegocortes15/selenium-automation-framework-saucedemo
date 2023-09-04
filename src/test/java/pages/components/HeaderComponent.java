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

    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCartButton;

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    @Step("⏩ Click on burger button")
    public void clickBurgerButton() {
        seleniumFactory.click(burgerButton);
    }

    @Step("⏩ Click on shopping cart button")
    public CartPage clickShoppingCartButton() {
        seleniumFactory.click(shoppingCartButton);
        return new CartPage(driver);
    }
}
