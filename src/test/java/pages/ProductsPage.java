package pages;

import com.google.common.base.Functions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.components.HeaderComponent;
import pages.components.SideBar;
import utils.SupportFactory;

import java.util.*;
import java.util.stream.Collectors;

public class ProductsPage extends BasePage {

    private final HeaderComponent headerComponent;
    private final SideBar sideBarMenu;
    private final SupportFactory supportFactory;
    private Set<Integer> indexProductsToAdd;
    private String itemsAdded;

    @FindBy(className = "title")
    private WebElement pageTitle;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> itemNameList;

    @FindBy(className = "inventory_item_price")
    private List<WebElement> itemPriceList;

    @FindBy(css = "button.btn_inventory")
    private List<WebElement> itemBtnList;

    @FindBy(css = "[data-test='product_sort_container']")
    private WebElement dropdownProductSort;

    @FindBy(className = "inventory_item")
    private List<WebElement> itemList;

    public ProductsPage(WebDriver driver) {
        super(driver);
        this.headerComponent = new HeaderComponent(driver);
        this.sideBarMenu = new SideBar(driver);
        this.supportFactory = new SupportFactory();
    }

    @Step("🧪 Verify current page title: \"{0}\"")
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

    @Step("⏩ Sort products by visible text: \"{0}\"")
    public void sortProductsByVisibleText(String optionByVisibleText) {
        seleniumFactory.selectByVisibleText(dropdownProductSort, optionByVisibleText);
    }

    @Step("🧪 Verify prices ordered: \"{1}\"")
    public void verifyPricesOrdered(List<String> actualPrices, List<String> expectedPrices) {
        String actual = supportFactory.listToString(actualPrices);
        String expected = supportFactory.listToString(expectedPrices);
        seleniumFactory.verifyCompareValues(actual, expected);
    }

    public void productsRandomToAdd() {
        int productListLength = itemList.size();
        Set<Integer> newIndexProductList = new HashSet<>();
        for (int i = 0; i < productListLength; i++) {
            newIndexProductList.add(supportFactory.getRandomNaturalNumber(productListLength));
        }
        this.indexProductsToAdd = newIndexProductList;
    }

    @Step("⏩ Add products")
    public void addProducts() {
        this.productsRandomToAdd();
        List<String> productsAdded = new ArrayList<>();
        for (int i = 0; i < indexProductsToAdd.size(); i++) {
            HashMap<String, String> item = new HashMap<>();
            item.put("itemName", seleniumFactory.getTextByIndex(itemNameList, i));
            item.put("itemPrice", seleniumFactory.getTextByIndex(itemPriceList, i));
            productsAdded.add(String.valueOf(item));
            seleniumFactory.clickByIndex(itemBtnList, i);
        }
        this.itemsAdded = supportFactory.listToString(productsAdded);
        seleniumFactory.embedFullPageScreenshot("Products added");
    }

    @Step("⏩ Add product: \"{0}\"")
    public void addSpecificProduct(String productName) {
        List<String> productsAdded = new ArrayList<>();
        HashMap<String, String> item = new HashMap<>();
        String reformatProductName = productName.toLowerCase();
        List<String> productListName = itemNameList.stream().map(name -> name.getText().toLowerCase()).collect(Collectors.toList());
        int indexProduct = productListName.indexOf(reformatProductName);
        item.put("itemName", seleniumFactory.getTextByIndex(itemNameList, indexProduct));
        item.put("itemPrice", seleniumFactory.getTextByIndex(itemPriceList, indexProduct));
        productsAdded.add(String.valueOf(item));
        seleniumFactory.clickByIndex(itemBtnList, indexProduct);
        this.itemsAdded = supportFactory.listToString(productsAdded);
        seleniumFactory.embedFullPageScreenshot(productName + "Product added");
    }

    public String getItemsAdded() {
        return this.itemsAdded;
    }

    public HeaderComponent getHeaderComponent() {
        return headerComponent;
    }

    public SideBar getSideBarMenu() {
        return sideBarMenu;
    }
}
