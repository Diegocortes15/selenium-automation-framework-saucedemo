package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends BasePage {

    @FindBy(className = "title")
    private WebElement pageTitle;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    @Step("🧪 Verify current page title: \"{0}\"")
    public void verifyCurrentPage(String expectedTitle) {
        seleniumFactory.verifyText(pageTitle, expectedTitle);
    }

}
