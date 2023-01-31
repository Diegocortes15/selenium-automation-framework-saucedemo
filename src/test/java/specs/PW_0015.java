package specs;

import core.ReadJsonData;
import io.qameta.allure.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

@Feature("Shopping Cart")
public class PW_0015 extends BaseTest {

    private final String storyParent = "pw-0015";

    @Test
    @Story(storyParent)
    @Description("Validate all the items that have been added to the shopping cart")
    @Severity(SeverityLevel.CRITICAL)
    public void pw_0016() {
        ReadJsonData readDataTestCase = new ReadJsonData("src/test/java/data/" + storyParent + "/pw-0016.json");
        JSONObject dataTestCase = readDataTestCase.getJsonObject();

        JSONObject dataLoginPage = (JSONObject) dataTestCase.get("loginPage");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
        ProductsPage productsPage = loginPage.login((String) dataLoginPage.get("username"), (String) dataLoginPage.get("password"));
        productsPage.addProducts();
        String productsAddedToCart = productsPage.getItemsAdded();
        CartPage cartPage = productsPage.getHeaderComponent().clickShoppingCartButton();
        cartPage.verifyProductsAdded(productsAddedToCart);
    }

    @Test
    @Story(storyParent)
    @Description("Validate the correct product was added to the cart")
    @Severity(SeverityLevel.CRITICAL)
    public void pw_0017() {
        ReadJsonData readDataTestCase = new ReadJsonData("src/test/java/data/" + storyParent + "/pw-0017.json");
        JSONObject dataTestCase = readDataTestCase.getJsonObject();

        JSONObject dataLoginPage = (JSONObject) dataTestCase.get("loginPage");
        JSONObject dataProductsPage = (JSONObject) dataTestCase.get("productsPage");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
        ProductsPage productsPage = loginPage.login((String) dataLoginPage.get("username"), (String) dataLoginPage.get("password"));
        productsPage.addSpecificProduct((String) dataProductsPage.get("addProduct"));
        String productsAddedToCart = productsPage.getItemsAdded();
        CartPage cartPage = productsPage.getHeaderComponent().clickShoppingCartButton();
        cartPage.verifyProductsAdded(productsAddedToCart);
    }

}
