package specs;

import core.ReadJsonData;
import io.qameta.allure.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

@Feature("Login")
public class PW_0002 extends BaseTest {

    private final String storyParent = "pw-0002";

    @Test
    @Story(storyParent)
    @Description("Validate the 'standard_user' user can logout")
    @Severity(SeverityLevel.NORMAL)
    public void pw_0010() {
        ReadJsonData readDataTestCase = new ReadJsonData("src/test/java/data/" + storyParent + "/pw-0010.json");
        JSONObject dataTestCase = readDataTestCase.getJsonObject();

        JSONObject dataLoginPage = (JSONObject) dataTestCase.get("loginPage");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
        ProductsPage productsPage = loginPage.login((String) dataLoginPage.get("username"), (String) dataLoginPage.get("password"));
        productsPage.getHeaderComponent().clickBurgerButton();
        productsPage.getSideBarMenu().clickLogoutButton();
        loginPage.verifyLoginURL();
    }

    @Test
    @Story(storyParent)
    @Description("Validate the 'problem_user' user can logout")
    @Severity(SeverityLevel.NORMAL)
    public void pw_0011() {
        ReadJsonData readDataTestCase = new ReadJsonData("src/test/java/data/" + storyParent + "/pw-0011.json");
        JSONObject dataTestCase = readDataTestCase.getJsonObject();

        JSONObject dataLoginPage = (JSONObject) dataTestCase.get("loginPage");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
        ProductsPage productsPage = loginPage.login((String) dataLoginPage.get("username"), (String) dataLoginPage.get("password"));
        productsPage.getHeaderComponent().clickBurgerButton();
        productsPage.getSideBarMenu().clickLogoutButton();
        loginPage.verifyLoginURL();
    }

    @Test
    @Story(storyParent)
    @Description("Validate the 'performance_glitch_user' user can logout")
    @Severity(SeverityLevel.NORMAL)
    public void pw_0012() {
        ReadJsonData readDataTestCase = new ReadJsonData("src/test/java/data/" + storyParent + "/pw-0012.json");
        JSONObject dataTestCase = readDataTestCase.getJsonObject();

        JSONObject dataLoginPage = (JSONObject) dataTestCase.get("loginPage");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
        ProductsPage productsPage = loginPage.login((String) dataLoginPage.get("username"), (String) dataLoginPage.get("password"));
        productsPage.getHeaderComponent().clickBurgerButton();
        productsPage.getSideBarMenu().clickLogoutButton();
        loginPage.verifyLoginURL();
    }

}
