package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.SupportFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CartPage extends BasePage {

    private final SupportFactory supportFactory;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> itemNameList;

    @FindBy(className = "inventory_item_price")
    private List<WebElement> itemPriceList;

    @FindBy(className = "cart_item")
    private List<WebElement> itemCartList;

    @FindBy(css = "[data-test='checkout']")
    private WebElement buttonCheckout;

    public CartPage(WebDriver driver) {
        super(driver);
        this.supportFactory = new SupportFactory();
    }

    @Step("⏩ Get cart products")
    public String getCartProducts() {
        List<String> cartProductsAdded = new ArrayList<>();
        for (int i = 0; i < itemCartList.size(); i++) {
            HashMap<String, String> item = new HashMap<>();
            item.put("itemName", seleniumFactory.getTextByIndex(itemNameList, i));
            item.put("itemPrice", seleniumFactory.getTextByIndex(itemPriceList, i));
            cartProductsAdded.add(String.valueOf(item));
        }
        return supportFactory.listToString(cartProductsAdded);
    }

    @Step("🧪 Verify products added: \"{0}\"")
    public void verifyProductsAdded(String expectedProductsAdded) {
        String products = this.getCartProducts();
        seleniumFactory.verifyCompareValues(products, expectedProductsAdded);
    }

    @Step("⏩ Click on checkout button")
    public CheckoutInformationPage clickCheckoutButton() {
        seleniumFactory.click(buttonCheckout);
        return new CheckoutInformationPage(driver);
    }

}
