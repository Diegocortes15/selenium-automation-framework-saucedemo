package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends BasePage {

    @FindBy(className = "title")
    private WebElement pageTitle;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public void verifyCurrentPage(String expectedTitle) {
        seleniumFactory.verifyText(pageTitle, expectedTitle);
    }

}
