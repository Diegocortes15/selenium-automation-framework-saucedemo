package specs;

import io.qameta.allure.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import utils.ReadJsonData;

public class PW_0001 extends BaseTest {

    protected final String storyParent = "pw-0001";

    protected final ReadJsonData readDataTestCase_1 = new ReadJsonData("src/test/java/data/" + storyParent + "/pw-0003.json");
    protected final JSONObject dataTestCase_1 = readDataTestCase_1.getJsonObject();
    @Test
    @Feature("Login")
    @Story("Verify 'standard_user' can login")
    @Description("Validate the 'standard_user' user navigates to the products page when logged in")
    @Severity(SeverityLevel.BLOCKER)
    public void pw_0003() {
        JSONObject dataLoginPage = (JSONObject) dataTestCase_1.get("loginPage");
        JSONObject dataProductsPage = (JSONObject) dataTestCase_1.get("productsPage");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
        loginPage.enterUsername((String) dataLoginPage.get("username"));
        loginPage.verifyUsername((String) dataLoginPage.get("username"));
        loginPage.enterPassword((String) dataLoginPage.get("password"));
        loginPage.verifyPassword((String) dataLoginPage.get("password"));
        ProductsPage productsPage = loginPage.clickButtonSubmit();
        productsPage.verifyCurrentPage((String) dataProductsPage.get("titlePage"));
    }

    protected final ReadJsonData readDataTestCase_2 = new ReadJsonData("src/test/java/data/" + storyParent + "/pw-0004.json");
    protected final JSONObject dataTestCase_2 = readDataTestCase_2.getJsonObject();
    @Test
    @Feature("Login")
    @Story("Verify 'problem_user' can login")
    @Description("Validate the 'problem_user' user navigates to the products page when logged in")
    @Severity(SeverityLevel.BLOCKER)
    public void pw_0004() {
        JSONObject dataLoginPage = (JSONObject) dataTestCase_2.get("loginPage");
        JSONObject dataProductsPage = (JSONObject) dataTestCase_2.get("productsPage");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
        loginPage.enterUsername((String) dataLoginPage.get("username"));
        loginPage.verifyUsername((String) dataLoginPage.get("username"));
        loginPage.enterPassword((String) dataLoginPage.get("password"));
        loginPage.verifyPassword((String) dataLoginPage.get("password"));
        ProductsPage productsPage = loginPage.clickButtonSubmit();
        productsPage.verifyCurrentPage((String) dataProductsPage.get("titlePage"));
    }

    protected final ReadJsonData readDataTestCase_3 = new ReadJsonData("src/test/java/data/" + storyParent + "/pw-0005.json");
    protected final JSONObject dataTestCase_3 = readDataTestCase_3.getJsonObject();
    @Test
    @Feature("Login")
    @Story("Verify 'performance_glitch_user' can login")
    @Description("Validate 'performance_glitch_user' the user navigates to the products page when logged in")
    @Severity(SeverityLevel.BLOCKER)
    public void pw_0005() {
        JSONObject dataLoginPage = (JSONObject) dataTestCase_3.get("loginPage");
        JSONObject dataProductsPage = (JSONObject) dataTestCase_3.get("productsPage");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
        loginPage.enterUsername((String) dataLoginPage.get("username"));
        loginPage.verifyUsername((String) dataLoginPage.get("username"));
        loginPage.enterPassword((String) dataLoginPage.get("password"));
        loginPage.verifyPassword((String) dataLoginPage.get("password"));
        ProductsPage productsPage = loginPage.clickButtonSubmit();
        productsPage.verifyCurrentPage((String) dataProductsPage.get("titlePage"));
    }
}
