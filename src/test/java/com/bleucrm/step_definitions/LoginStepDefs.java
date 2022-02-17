package com.bleucrm.step_definitions;

import com.bleucrm.pages.LoginPage;
import com.bleucrm.utilities.BrowserUtils;
import com.bleucrm.utilities.ConfigurationReader;
import com.bleucrm.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {

    @Given("the {string} is on the login page")
    public void the_is_on_the_login_page(String string) {
      Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("the {string} enters the username password")
    public void the_enters_the_username_password(String string) {
        LoginPage loginPage=new LoginPage();
        loginPage.login2(string);
        BrowserUtils.waitFor(1);
    }


    @Then("the {string} should be able to login")
    public void the_should_be_able_to_login(String string) {
        String actualUrl=Driver.get().getCurrentUrl();
        String expectedUrl="https://qa.bleucrm.com/stream/?login=yes";
//        System.out.println("actualUrl = " + actualUrl);
//        System.out.println("expectedUrl = " + expectedUrl);
        Assert.assertEquals(expectedUrl,actualUrl);
    }

    @Given("the {string} is logged in")
    public void the_is_logged_in(String string) {
       //navigate to login page
        Driver.get().get(ConfigurationReader.get("url"));

        //Enter data
        LoginPage loginPage=new LoginPage();
        loginPage.login2(string);
        BrowserUtils.waitFor(1);

        //verify url
        String actualUrl=Driver.get().getCurrentUrl();
        String expectedUrl="https://qa.bleucrm.com/stream/?login=yes";
        Assert.assertEquals(expectedUrl,actualUrl);
    }


}
