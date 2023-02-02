package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverviewPage extends BasePage {

    @FindBy(css = "[data-test='finish']")
    private WebElement buttonFinish;

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    @Step("⏩ Click on finish button")
    public CheckoutCompletePage clickButtonFinish() {
        seleniumFactory.click(buttonFinish);
        return new CheckoutCompletePage(driver);
    }
}
