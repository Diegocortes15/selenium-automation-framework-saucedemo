package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import core.SeleniumFactory;

public abstract class BasePage {
    protected WebDriver driver;
    protected SeleniumFactory seleniumFactory;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.seleniumFactory = new SeleniumFactory(this.driver);
    }
}
