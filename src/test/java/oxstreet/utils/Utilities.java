package oxstreet.utils;

import oxstreet.dao.SearchDAO;
import net.serenitybdd.core.pages.WebElementFacade;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Utilities {

    /**
     * @param file
     * @return a user with data in csv file
     */
    public static SearchDAO getSearchData(String file) {
        SearchDAO searchDAO = null;
        try {
            searchDAO = SearchDAO.readAllData(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return searchDAO;
    }

    public static WebElement waitElementToBeClickable(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Verify is selected option is existing in list
     *
     * @param listOption
     * @param inputtedOption
     * @return
     */
    public static boolean isSelectedOptionExistingInList(List<WebElementFacade> listOption, String inputtedOption) {
        boolean isExisting = false;
        for (WebElement element : listOption) {
            if (element.getText().equals(inputtedOption)) {
                isExisting = true;
                break;
            }
        }
        return isExisting;
    }

    /**
     * Wait for page is fully loaded
     *
     * @param driver
     */
    public static void waitForPageLoaded(WebDriver driver) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            @NullableDecl
            @Override
            public Boolean apply(@NullableDecl WebDriver webDriver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }
        };
        try {
            Thread.sleep(5000);
            WebDriverWait wait = new WebDriverWait(driver, 50);
            wait.until(expectation);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Scroll to the designated element before performing further operation
     *
     * @param driver
     * @param element
     */
    public static void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
}
