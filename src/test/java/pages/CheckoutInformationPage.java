package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutInformationPage extends BasePage {

    @FindBy(css = "[data-test='firstName']")
    private WebElement inputFirstName;

    @FindBy(css = "[data-test='lastName']")
    private WebElement inputLastName;

    @FindBy(css = "[data-test='postalCode']")
    private WebElement inputPostalCode;

    @FindBy(css = "[data-test='continue']")
    private WebElement buttonContinue;

    public CheckoutInformationPage(WebDriver driver) {
        super(driver);
    }

    public void enterFirstName(String strFirstName) {
        seleniumFactory.sendKeys(inputFirstName, strFirstName);
    }

    public void enterLastName(String strLastName) {
        seleniumFactory.sendKeys(inputLastName, strLastName);
    }

    public void enterPostalCode(String strPostalCode) {
        seleniumFactory.sendKeys(inputPostalCode, strPostalCode);
    }

    public CheckoutOverviewPage clickButtonContinue() {
        seleniumFactory.click(buttonContinue);
        return new CheckoutOverviewPage(driver);
    }

    public CheckoutOverviewPage fillInformation(String strFirstName, String strLastName, String strPostalCode) {
        this.enterFirstName(strFirstName);
        this.enterLastName(strLastName);
        this.enterPostalCode(strPostalCode);
        seleniumFactory.embedFullPageScreenshot("Information completed with " + ", " + strFirstName + ", " + strLastName + ", " + strPostalCode);
        return this.clickButtonContinue();
    }

}
