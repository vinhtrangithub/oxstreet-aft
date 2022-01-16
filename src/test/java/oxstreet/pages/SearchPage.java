package oxstreet.pages;

import org.openqa.selenium.Keys;
import oxstreet.stories.Search;
import net.serenitybdd.core.pages.WebElementFacade;
import oxstreet.utils.Utilities;

import java.util.List;

public class SearchPage extends BasePage {

    String searchTextField = "id=search";
    String productList = "xpath=//p[@class='product-name']";

    public void searchItem(String value){
        Utilities.waitElementToBeClickable(getDriver(), getElement(searchTextField));
        getElement(searchTextField).sendKeys(value);
        getElement(searchTextField).sendKeys(Keys.RETURN);
        Utilities.waitForPageLoaded(getDriver());
    }

    public boolean verifyTheResult(String expected){
        List<WebElementFacade> lstProduct = getElements(productList);
        for (WebElementFacade element : lstProduct) {
            String strElement = element.getText();
            if (strElement.equals(expected)) {
                return true;
            }
        }
        return false;
    }

}
