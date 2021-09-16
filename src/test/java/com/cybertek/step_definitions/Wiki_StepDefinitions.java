package com.cybertek.step_definitions;

import com.cybertek.pages.WikiPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Wiki_StepDefinitions {

    WikiPage wikiPage = new WikiPage();

    @Given("User is on Wikipedia home page")
    public void user_is_on_wikipedia_home_page() {
        String url = ConfigurationReader.getProperty("wikiUrl");
        Driver.getDriver().get(url);

    }

    @When("User types {string} in the wiki search box")
    public void user_types_in_the_wiki_search_box(String string) {
        wikiPage.searchBox.sendKeys(string);
    }

    @When("User clicks wiki search button")
    public void user_clicks_wiki_search_button() {
        wikiPage.searchButton.click();
    }

    @Then("User sees {string} is in the wiki title")
    public void user_sees_is_in_the_wiki_title(String string) {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = string +" - Wikipedia";

        Assert.assertTrue(actualTitle.equalsIgnoreCase(expectedTitle));
    }


    @Then("User sees {string} in the main header")
    public void userSeesInTheMainHeader(String arg0) {

        String actualHeaderText = wikiPage.mainHeader.getText();
        String expectedHeaderText= arg0;

        //Checking the context of the web element
        Assert.assertTrue(actualHeaderText.equalsIgnoreCase(expectedHeaderText));

        //Checking if the web element displayed or not
        Assert.assertTrue(wikiPage.mainHeader.isDisplayed());

        //BREAK UNTIL 2.22PM CST
        //BREAK UNTIL 3.22PM EST

    }
}