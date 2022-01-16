package oxstreet.steps;

import org.junit.Assert;
import oxstreet.dao.SearchDAO;
import oxstreet.pages.*;
import net.thucydides.core.annotations.Step;

public class SearchSteps {

    HomePage homePage;
    SignInPage signInPage;
    SearchPage searchPage;

    @Step("Navigate to Home page.")
    public SearchSteps openPage(){
        homePage.openHomePage();
        return this;
    }

    @Step("Navigate to SignIn page.")
    public void navigateToSignInPage(){
        homePage.gotoSignInPage();
    }

    @Step("Sign in as a user.")
    public void signInUser(SearchDAO searchDAO){
        signInPage.enterEmail(searchDAO.getEmailAddress());
        signInPage.enterPassword(searchDAO.getPassword());
        signInPage.clickOnLoginButton();
    }

    @Step("Search an item.")
    public void searchItem(SearchDAO searchDAO){
        searchPage.searchItem(searchDAO.getSearch());
    }

    @Step("Validate that product exists on the first page")
    public void validateTheProductExist(SearchDAO searchDAO){
        Assert.assertTrue("Can't find the value on the first page.", searchPage.verifyTheResult(searchDAO.getExpectedResult()));
    }
}
