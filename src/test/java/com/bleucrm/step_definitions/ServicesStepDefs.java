package com.bleucrm.step_definitions;

import com.bleucrm.pages.DashboardPage;
import com.bleucrm.pages.ServicesPage;
import com.bleucrm.utilities.BrowserUtils;
import com.bleucrm.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

import java.text.ParseException;
import java.util.*;

public class ServicesStepDefs {


    @When("the user clicks {string} page {string} module")
    public void the_user_clicks_page_module(String string, String string2) {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToTab("Services");

        ServicesPage servicesPage = new ServicesPage();
        servicesPage.servicesPageModules("Ideas");
    }

    @When("the user clicks New Idea button")
    public void the_user_clicks_New_Idea_button() {
        ServicesPage servicesPage = new ServicesPage();
        servicesPage.createNewIdea();
    }

    @When("creates new idea using following information")
    public void creates_new_idea_using_following_information(Map<String, String> map) {
        ServicesPage servicesPage = new ServicesPage();
        servicesPage.setTitle(map.get("Title"));
        servicesPage.setIdeaDescription(map.get("Idea description"));
        servicesPage.setTags(map.get("Tags"));

        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        jse.executeScript("window.scrollBy(0,250)");

        BrowserUtils.waitFor(1);

        servicesPage.setCategory(map.get("Category"));
    }

    @When("the user clicks Suggest New Idea")
    public void the_user_clicks_Suggest_New_Idea() {
        ServicesPage servicesPage = new ServicesPage();
        servicesPage.suggestNewIdea.click();
        BrowserUtils.waitFor(2);
    }

    @Then("new idea should be created")
    public void new_idea_should_be_created() {
        ServicesPage servicesPage = new ServicesPage();

        Assert.assertTrue(servicesPage.newIdea.isDisplayed());
        System.out.println("How to verify new idea created");
    }

    @When("the user clicks plus sign next to Rating")
    public void the_user_clicks_plus_sign_next_to_Rating() {
        ServicesPage servicesPage = new ServicesPage();

        servicesPage.clickLikeButton();
        Driver.get().navigate().refresh();
        BrowserUtils.waitFor(1);

    }

    @When("the user unclicks plus sign next to Rating")
    public void the_user_unclicks_plus_sign_next_to_Rating() {
        ServicesPage servicesPage = new ServicesPage();

        servicesPage.unClickLikeButton();
        Driver.get().navigate().refresh();
        BrowserUtils.waitFor(1);
    }


    @Then("Like button should be selected")
    public void like_button_should_be_selected() {
        ServicesPage servicesPage = new ServicesPage();

        Assert.assertTrue(servicesPage.getPlusButtonTitleAttribute().equals("Stop liking this item"));

    }

    @Then("Like button should be unselected")
    public void like_button_should_be_unselected() {
        ServicesPage servicesPage = new ServicesPage();

        Assert.assertTrue(servicesPage.getPlusButtonTitleAttribute().equals("Like"));

    }


    @When("the user clicks minus sign next to Rating")
    public void the_user_clicks_minus_sign_next_to_Rating() {
        ServicesPage servicesPage = new ServicesPage();
        servicesPage.clickDislikeButton();
        Driver.get().navigate().refresh();
        BrowserUtils.waitFor(1);
    }

    @When("the user unclicks minus sign next to Rating")
    public void the_user_unclicks_minus_sign_next_to_Rating() {
        ServicesPage servicesPage = new ServicesPage();
        servicesPage.unClickDislikeButton();
        Driver.get().navigate().refresh();
        BrowserUtils.waitFor(1);
    }


    @Then("Dislike button should be selected")
    public void dislike_button_should_be_selected() {
        ServicesPage servicesPage = new ServicesPage();

        Assert.assertTrue(servicesPage.getMinusButtonTitleAttribute().equals("Stop liking this item"));
    }

    @Then("Dislike button should be unselected")
    public void dislike_button_should_be_unselected() {
        ServicesPage servicesPage = new ServicesPage();

        Assert.assertTrue(servicesPage.getMinusButtonTitleAttribute().equals("Unlike"));
    }

    @When("the user clicks date added button")
    public void the_user_clicks_date_added_button() {
        ServicesPage servicesPage = new ServicesPage();
        servicesPage.dateAddedButton.click();
        BrowserUtils.waitFor(1);
    }

    @Then("the user should see the messages sorted by date")
    public void the_user_should_see_the_messages_sorted_by_date() throws ParseException {
        List<Date> actualDates=new ArrayList<>();
        List<Date> expectedDates=new ArrayList<>();

        ServicesPage servicesPage = new ServicesPage();

        actualDates=servicesPage.sortByDate();
        expectedDates=servicesPage.sortByDate();
        Collections.sort(expectedDates);
        Collections.reverse(expectedDates);

        System.out.println("actualDates = " + actualDates.toString());
        System.out.println("expectedDates = " + expectedDates.toString());

        Assert.assertTrue("verify dates are sorted",actualDates.equals(expectedDates));
        //the problem is on the webpage there are date as " February 20, 2022 12:59 am"
        //I think after 12.00 it should reset to 00.00
        //while it resets at 13.00

    }
    //master branch

}
