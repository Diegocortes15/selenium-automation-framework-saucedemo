package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverviewPage extends BasePage {

    @FindBy(css = "[data-test='finish']")
    private WebElement buttonFinish;

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutCompletePage clickButtonFinish() {
        seleniumFactory.click(buttonFinish);
        return new CheckoutCompletePage(driver);
    }
}
