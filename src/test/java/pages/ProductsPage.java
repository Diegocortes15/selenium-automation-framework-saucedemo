package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.components.HeaderComponent;

public class ProductsPage extends BasePage {

    HeaderComponent headerComponent;

    @FindBy(className = "title")
    private WebElement pageTitle;

    public ProductsPage(WebDriver driver) {
        super(driver);
        headerComponent = new HeaderComponent(driver);
    }

    public void verifyCurrentPage(String expectedTitlePage) {
        seleniumFactory.verifyText(pageTitle, expectedTitlePage);
    }

    public HeaderComponent getHeaderComponent() {
        return headerComponent;
    }
}
