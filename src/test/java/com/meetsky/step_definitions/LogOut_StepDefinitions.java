package com.meetsky.step_definitions;

import com.meetsky.pages.LogOutPage_Burak;
import com.meetsky.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogOut_StepDefinitions {

    LogOutPage_Burak logOutPage = new LogOutPage_Burak();

    @Given("User click to settings expand button on top-right corner")
    public void userClickToSettingsExpandButtonOnTopRightCorner() {
        logOutPage.topRightSettingsExpandButton.click();
    }

    @Then("Click to Log out button")
    public void clickToLogOutButton() {
        logOutPage.accountMenuLogoutButton.click();
    }

    @Then("User should be able to logged out successfully and can see the login page")
    public void userShouldBeAbleToLoggedOutSuccessfullyAndCanSeeTheLoginPage() {
        Assert.assertTrue( Driver.getDriver().getCurrentUrl().startsWith("https://qa.meetsky.net/index.php/login"));
    }

    @And("User should not be able to go to home page again by clicking step back button")
    public void userShouldNotBeAbleToGoToHomePageAgainByClickingStepBackButton() {
        Driver.getDriver().navigate().back();
        new WebDriverWait(Driver.getDriver(), 10).until(
                webDriver -> webDriver.getCurrentUrl().startsWith("https://qa.meetsky.net/index.php/login"));
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("login"));
    }
}