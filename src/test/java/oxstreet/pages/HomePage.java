package oxstreet.pages;

import oxstreet.utils.Utilities;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.EnvironmentVariables;

public class HomePage extends BasePage{
    EnvironmentVariables environmentVariables;

    String burgerMenu = "xpath=//div[@class='sc-jKJlTe eJYhDh']";
    String loginButton = "xpath=//button[contains(text(),'Log in')]";

    public void openHomePage() {
        getDriver().get(EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("webdriver.base.url"));
    }

    public SignInPage gotoSignInPage() {
        Utilities.waitElementToBeClickable(getDriver(),getElement(burgerMenu));
        getElement(burgerMenu).click();
        Utilities.waitElementToBeClickable(getDriver(),getElement(loginButton));
        getElement(loginButton).click();
        return this.switchToPage(SignInPage.class);
    }
}
