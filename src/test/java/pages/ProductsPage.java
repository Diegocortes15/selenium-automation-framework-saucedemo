package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {

    @FindBy(className = "title")
    WebElement pageTitle;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void verifyCurrentPage(String expectedTitlePage) {
        verifyText(pageTitle, expectedTitlePage);
    }
}
