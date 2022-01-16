package oxstreet.stepdefinitions;

import oxstreet.dao.SearchDAO;
import oxstreet.steps.SearchSteps;
import oxstreet.utils.Utilities;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class SearchStepDefinition {

    @Steps
    SearchSteps searchSteps;

    static SearchDAO searchDAO;

    @BeforeStory
    public void readTestData(){
        this.searchDAO = Utilities.getSearchData("searchdata.csv");
    }

    @Given("User is on the OxStreet page")
    public void on_the_home_page() {
        searchSteps.openPage();
    }

    @When("User navigate to Sign In page")
    public void user_navigate_to_SignIn_page() {
        searchSteps.navigateToSignInPage();
    }

    @When("Sign in as a user")
    public void sign_in_as_a_user() {
        searchSteps.signInUser(searchDAO);
    }


    @When("Search for item")
    public void search_for_item() {
        searchSteps.searchItem(searchDAO);
    }

    @When("Validate that product exists on the first page")
    public void validate_the_product_exist() {
        searchSteps.validateTheProductExist(searchDAO);
    }

    @Then("all the result titles should contain the word \"$keyword\"")
    public void all_the_result_titles_should_contain_the_word(String term) {

    }
}
