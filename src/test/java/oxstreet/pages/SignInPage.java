package oxstreet.pages;

import oxstreet.utils.Utilities;

public class SignInPage extends BasePage{

    String emailTextField = "id=email";
    String passwordTextField = "id=password";
    String loginButton = "xpath=//button[contains(text(),'Log in')]";

    public void enterEmail(String email){
        getElement(emailTextField).sendKeys(email);
    }

    public void enterPassword(String password){
        getElement(passwordTextField).sendKeys(password);
    }

    public SearchPage clickOnLoginButton(){
        getElement(loginButton).click();
        Utilities.waitForPageLoaded(getDriver());
        return this.switchToPage(SearchPage.class);
    }

}
