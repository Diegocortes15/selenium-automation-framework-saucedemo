package pages;

import com.google.common.base.Functions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.components.HeaderComponent;
import utils.SupportFactory;

import java.util.List;
import java.util.stream.Collectors;

public class ProductsPage extends BasePage {

    private final HeaderComponent headerComponent;
    private final SupportFactory supportFactory;

    @FindBy(className = "title")
    private WebElement pageTitle;

    @FindBy(className = "inventory_item_price")
    private List<WebElement> itemPriceList;

    @FindBy(css = "[data-test='product_sort_container']")
    private WebElement dropdownProductSort;

    public ProductsPage(WebDriver driver) {
        super(driver);
        this.headerComponent = new HeaderComponent(driver);
        this.supportFactory = new SupportFactory();
    }

    public void verifyCurrentPage(String expectedTitlePage) {
        seleniumFactory.verifyText(pageTitle, expectedTitlePage);
    }

    public List<String> getProductPrices() {
        return itemPriceList.stream().map(price -> price.getText().substring(1)).collect(Collectors.toList());
    }

    public List<String> expectedSortPriceLowToHigh() {
        List<Double> orderedPrices = getProductPrices().stream().map(Double::parseDouble).sorted().collect(Collectors.toList());
        return orderedPrices.stream().map(Functions.toStringFunction()).collect(Collectors.toList());
    }

    public void sortProductsByVisibleText(String optionByVisibleText) {
        seleniumFactory.selectByVisibleText(dropdownProductSort, optionByVisibleText);
    }

    public void verifyPricesOrdered(List<String> actualPrices, List<String> expectedPrices) {
        String actual = supportFactory.ListToString(actualPrices);
        String expected = supportFactory.ListToString(expectedPrices);
        seleniumFactory.verifyCompareValues(actual, expected);
    }

    public HeaderComponent getHeaderComponent() {
        return headerComponent;
    }
}
