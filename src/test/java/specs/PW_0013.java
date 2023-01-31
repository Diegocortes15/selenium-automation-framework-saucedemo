package specs;

import core.ReadJsonData;
import io.qameta.allure.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

import java.util.List;

@Feature("Sort Products")
public class PW_0013 extends BaseTest {

    private final String storyParent = "pw-0013";

    @Test
    @Story(storyParent)
    @Description("Validate the products have been sorted by price correctly, low to high")
    @Severity(SeverityLevel.NORMAL)
    public void pw_0014() {
        ReadJsonData readDataTestCase = new ReadJsonData("src/test/java/data/" + storyParent + "/pw-0014.json");
        JSONObject dataTestCase = readDataTestCase.getJsonObject();

        JSONObject dataLoginPage = (JSONObject) dataTestCase.get("loginPage");
        JSONObject dataProductsPage = (JSONObject) dataTestCase.get("productsPage");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
        ProductsPage productsPage = loginPage.login((String) dataLoginPage.get("username"), (String) dataLoginPage.get("password"));
        List<String> expectedPrices = productsPage.expectedSortPriceLowToHigh();
        productsPage.sortProductsByVisibleText((String) dataProductsPage.get("sortProducts"));
        List<String> actualPrices = productsPage.getProductPrices();
        productsPage.verifyPricesOrdered(actualPrices, expectedPrices);
    }

}
