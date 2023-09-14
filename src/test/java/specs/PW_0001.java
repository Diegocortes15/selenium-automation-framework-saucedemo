package specs;

import core.ReadJsonData;
import io.qameta.allure.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

@Feature("Login")
public class PW_0001 extends BaseTest {

    private final String storyParent = "pw-0001";

    @Test
    @Story(storyParent)
    @Description("Validate the 'standard_user' user navigates to the products page when logged in")
    @Severity(SeverityLevel.BLOCKER)
    public void pw_0003() {
        ReadJsonData readDataTestCase = new ReadJsonData("src/test/java/data/" + storyParent + "/pw-0003.json");
        JSONObject dataTestCase = readDataTestCase.getJsonObject();

        JSONObject dataLoginPage = (JSONObject) dataTestCase.get("loginPage");
        JSONObject dataProductsPage = (JSONObject) dataTestCase.get("productsPage");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
        loginPage.enterUsername((String) dataLoginPage.get("username"));
        loginPage.verifyUsername((String) dataLoginPage.get("username"));
        loginPage.enterPassword((String) dataLoginPage.get("password"));
        loginPage.verifyPassword((String) dataLoginPage.get("password"));
        ProductsPage productsPage = loginPage.clickButtonSubmit();
        productsPage.verifyCurrentPage((String) dataProductsPage.get("titlePage"));
    }

    @Test
    @Story(storyParent)
    @Description("Validate the 'problem_user' user navigates to the products page when logged in")
    @Severity(SeverityLevel.BLOCKER)
    public void pw_0004() {
        ReadJsonData readDataTestCase = new ReadJsonData("src/test/java/data/" + storyParent + "/pw-0004.json");
        JSONObject dataTestCase = readDataTestCase.getJsonObject();

        JSONObject dataLoginPage = (JSONObject) dataTestCase.get("loginPage");
        JSONObject dataProductsPage = (JSONObject) dataTestCase.get("productsPage");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
        loginPage.enterUsername((String) dataLoginPage.get("username"));
        loginPage.verifyUsername((String) dataLoginPage.get("username"));
        loginPage.enterPassword((String) dataLoginPage.get("password"));
        loginPage.verifyPassword((String) dataLoginPage.get("password"));
        ProductsPage productsPage = loginPage.clickButtonSubmit();
        productsPage.verifyCurrentPage((String) dataProductsPage.get("titlePage"));
    }

    @Test
    @Story(storyParent)
    @Description("Validate 'performance_glitch_user' the user navigates to the products page when logged in")
    @Severity(SeverityLevel.BLOCKER)
    public void pw_0005() {
        ReadJsonData readDataTestCase = new ReadJsonData("src/test/java/data/" + storyParent + "/pw-0005.json");
        JSONObject dataTestCase = readDataTestCase.getJsonObject();

        JSONObject dataLoginPage = (JSONObject) dataTestCase.get("loginPage");
        JSONObject dataProductsPage = (JSONObject) dataTestCase.get("productsPage");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
        loginPage.enterUsername((String) dataLoginPage.get("username"));
        loginPage.verifyUsername((String) dataLoginPage.get("username"));
        loginPage.enterPassword((String) dataLoginPage.get("password"));
        loginPage.verifyPassword((String) dataLoginPage.get("password"));
        ProductsPage productsPage = loginPage.clickButtonSubmit();
        productsPage.verifyCurrentPage((String) dataProductsPage.get("titlePage"));
    }

    @Test
    @Story(storyParent)
    @Description("Validate the 'locked_out_user' cannot login")
    @Severity(SeverityLevel.NORMAL)
    public void pw_0006() {
        ReadJsonData readDataTestCase = new ReadJsonData("src/test/java/data/" + storyParent + "/pw-0006.json");

        JSONObject dataTestCase = readDataTestCase.getJsonObject();
        JSONObject dataLoginPage = (JSONObject) dataTestCase.get("loginPage");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
        loginPage.login((String) dataLoginPage.get("username"), (String) dataLoginPage.get("password"));
        loginPage.clickButtonSubmit();
        loginPage.verifyValidationMessage((String) dataLoginPage.get("validationMessage"));
    }

    @Test
    @Story(storyParent)
    @Description("Validate the 'locked_out_user' cannot login")
    @Severity(SeverityLevel.NORMAL)
    public void pw_0007() {
        ReadJsonData readDataTestCase = new ReadJsonData("src/test/java/data/" + storyParent + "/pw-0007.json");

        JSONObject dataTestCase = readDataTestCase.getJsonObject();
        JSONObject dataLoginPage = (JSONObject) dataTestCase.get("loginPage");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
        loginPage.login((String) dataLoginPage.get("username"), (String) dataLoginPage.get("password"));
        loginPage.clickButtonSubmit();
        loginPage.verifyValidationMessage((String) dataLoginPage.get("validationMessage"));
    }

    @Test
    @Story(storyParent)
    @Description("Validate the 'locked_out_user' cannot login")
    @Severity(SeverityLevel.NORMAL)
    public void pw_0008() {
        ReadJsonData readDataTestCase = new ReadJsonData("src/test/java/data/" + storyParent + "/pw-0008.json");

        JSONObject dataTestCase = readDataTestCase.getJsonObject();
        JSONObject dataLoginPage = (JSONObject) dataTestCase.get("loginPage");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
        loginPage.login((String) dataLoginPage.get("username"), (String) dataLoginPage.get("password"));
        loginPage.clickButtonSubmit();
        loginPage.verifyValidationMessage((String) dataLoginPage.get("validationMessage"));
    }

    @Test
    @Story(storyParent)
    @Description("Validate the 'locked_out_user' cannot login")
    @Severity(SeverityLevel.NORMAL)
    public void pw_0009() {
        ReadJsonData readDataTestCase = new ReadJsonData("src/test/java/data/" + storyParent + "/pw-0009.json");

        JSONObject dataTestCase = readDataTestCase.getJsonObject();
        JSONObject dataLoginPage = (JSONObject) dataTestCase.get("loginPage");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.goTo();
        loginPage.login((String) dataLoginPage.get("username"), (String) dataLoginPage.get("password"));
        loginPage.clickButtonSubmit();
        loginPage.verifyValidationMessage((String) dataLoginPage.get("validationMessage"));
    }

}
