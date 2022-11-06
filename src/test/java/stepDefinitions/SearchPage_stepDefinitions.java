package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import pages.SearchPage;
import static utilities.BrowserUtil.*;
import utilities.ConfigurationReader;
import utilities.Driver;

public class SearchPage_stepDefinitions {
    WebDriver driver = Driver.getDriver();

    @Given("User navigates to search page")
    public void user_navigates_to_search_page() {
        driver.get(ConfigurationReader.getProperty("wikipediaBaseUrl"));
    }

    @When("user enters {string}")
    public void user_enters(String string) {
        //string comes from feature file dynamically.
        sendKeyByLocator(SearchPage.bySearchInputBox, string);
    }

    @And("user clicks the searchButton")
    public void userClicksTheSearchButton() {
        clickByObject(SearchPage.bySearchButton);
    }

    @Then("user verifies that headers include the {string}")
    public void userVerifiesThatHeadersIncludeThe(String string) {
        //here we verify that at least %90 of the result titles and text bodies contain the search keyword
        Assert.assertTrue(SearchPage.verifyTitlesContainKeyword(driver.findElements(SearchPage.bySearchResultTitles), string));
        Assert.assertTrue(SearchPage.verifyTextsContainKeyword(driver.findElements(SearchPage.bySearchResultTexts), string));
    }

    @Then("user verifies the page is the same \\(refreshes)")
    public void userVerifiesThePageIsTheSameRefreshes() {
       // Assert.assertEquals("https://en.wikipedia.org/w/index.php?search=&title=Special%3ASearch&profile=default&fulltext=1", driver.getCurrentUrl());
        Assert.assertEquals("https://en.wikipedia.org/w/index.php?search=&title=Special%3ASearch&profile=advanced&fulltext=1&ns0=1", driver.getCurrentUrl());
        //sometimes url is like: https://en.wikipedia.org/w/index.php?search=&title=Special%3ASearch&profile=advanced&fulltext=1&ns0=1
    }
}
