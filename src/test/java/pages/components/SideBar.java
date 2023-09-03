package pages.components;

import core.WaitType;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class SideBar extends BasePage {

    @FindBy(className = "bm-menu")
    private WebElement sideBarMenu;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutButton;

    public SideBar(WebDriver driver) {
        super(driver);
    }

    @Step("⏩ Wait until SideBarMenu will be visible")
    private void waitUntilSidebarVisible() {
        seleniumFactory.waitElementUntil(sideBarMenu, WaitType.VISIBLE);
    }

    @Step("⏩ Click on logout button")
    public void clickLogoutButton() {
        waitUntilSidebarVisible();
        seleniumFactory.click(logoutButton);
    }
}


