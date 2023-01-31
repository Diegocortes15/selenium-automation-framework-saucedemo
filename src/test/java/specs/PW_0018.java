package specs;

import core.ReadJsonData;
import io.qameta.allure.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import pages.*;

@Feature("E2E")
public class PW_0018 extends BaseTest {

    private final String storyParent = "pw-0018";

    @Test
    @Story(storyParent)
    @Description("Validate the user navigates to the order confirmation page with checkout information data set")
    @Severity(SeverityLevel.CRITICAL)
    public void pw_0019() {
        ReadJsonData readDataTestCase = new ReadJsonData("src/test/java/data/" + storyParent + "/pw-0019.json");
        JSONObject dataTestCase = readDataTestCase.getJsonObject();

        JSONObject dataLoginPage = (JSONObject) dataTestCase.get("loginPage");
        JSONObject dataCheckoutInformationPage = (JSONObject) dataTestCase.get("checkoutInformationPage");
        JSONObject dataCheckoutCompletePage = (JSONObject) dataTestCase.get("checkoutCompletePage");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
        ProductsPage productsPage = loginPage.login((String) dataLoginPage.get("username"), (String) dataLoginPage.get("password"));
        productsPage.addProducts();
        String productsAddedToCart = productsPage.getItemsAdded();
        CartPage cartPage = productsPage.getHeaderComponent().clickShoppingCartButton();
        cartPage.verifyProductsAdded(productsAddedToCart);
        CheckoutInformationPage checkoutInformationPage = cartPage.clickCheckoutButton();
        CheckoutOverviewPage checkoutOverviewPage = checkoutInformationPage.fillInformation((String) dataCheckoutInformationPage.get("firstName"), (String) dataCheckoutInformationPage.get("lastName"), (String) dataCheckoutInformationPage.get("postalCode"));
        CheckoutCompletePage completePage = checkoutOverviewPage.clickButtonFinish();
        completePage.verifyCurrentPage((String) dataCheckoutCompletePage.get("titlePage"));
    }

}
