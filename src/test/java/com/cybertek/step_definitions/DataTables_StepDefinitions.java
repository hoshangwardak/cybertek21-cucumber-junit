
package com.cybertek.step_definitions;

import com.cybertek.pages.DropDownsPage;
import com.cybertek.pages.SmartBearLoginPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class DataTables_StepDefinitions {

    SmartBearLoginPage smartBearLoginPage = new SmartBearLoginPage();
    DropDownsPage dropdownsPage = new DropDownsPage();

    @Then("User should see below words displayed")
    public void user_should_see_below_words_displayed(List<String> fruitList) {

        System.out.println("fruitList.size() = " + fruitList.size());
        System.out.println("fruitList = " + fruitList);

        for (String eachFruit : fruitList) {
            System.out.println("eachFruit = " + eachFruit);
        }
    }

    @Given("User is on the login page of SmartBear")
    public void user_is_on_the_login_page_of_smart_bear() {

        String url = ConfigurationReader.getProperty("smartBearUrl");
        Driver.getDriver().get(url);

    }

    @When("User enters below info")
    public void user_enters_below_info(Map<String, String> loginInfo) {

        /*  Map loginInfo
            username = Tester
            password = test
         */

        String username=  loginInfo.get("username"); //--> will return Tester
        String password = loginInfo.get("password"); //--> will return test

        smartBearLoginPage.loginToSmartBear(username, password);


    }

    @Then("User should see title changed to Web Orders")
    public void user_should_see_title_changed_to_web_orders() {

        BrowserUtils.titleVerification("Web Orders");

    }

    @Given("User is on the dropdowns page of practice tool")
    public void user_is_on_the_dropdowns_page_of_practice_tool() {

        Driver.getDriver().get("http://practice.cybertekschool.com/dropdown");

    }


    @Then("User should see below info in month dropdown")
    public void user_should_see_below_info_in_month_dropdown(List<String> expectedList) {

        Select monthDropdown = new Select(dropdownsPage.monthDropdown);


        //Basically we are comparing two list of strings
        //expected: List<String> expectedList
        //actual : BrowserUtils.getElementsText(monthDropdown.getOptions()) --> Returns List <String>

        List<String> actualTexts = BrowserUtils.getElementsText(monthDropdown.getOptions());

        Assert.assertTrue(expectedList.equals(actualTexts));





//        List<WebElement> monthsAsWebElement = monthDropdown.getOptions();
//
//        List<String> monthsAsString = new ArrayList<>();
//
//        for (WebElement each : monthsAsWebElement) {
//            monthsAsString.add(each.getText());
//        }

        //Assertion will compare the size of the lists first, if it is not equal it will fail the test.
        //If sizes are equal, than it will compare each element in the list
//        Assert.assertTrue(expectedList.equals(monthsAsString));


    }

}
