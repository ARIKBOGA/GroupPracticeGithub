package com.meetsky.step_definitions;

import com.meetsky.pages.LoginPage;
import com.meetsky.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;

public class Login_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    String expectedErrorMessage = "Wrong username or password.";
    String actualErrorMessage = "";

    @Given("User goes to login page")
    public void userGoesToLoginPage() {
        Driver.getDriver().get("https://qa.meetsky.net/index.php/login");
    }

    @When("User enters invalid {string} or leaves the input blank username")
    public void userEntersInvalidOrLeavesTheInputBlankUsername(String username) {
        if (username.isEmpty() || username.isBlank()) {
            expectedErrorMessage = "Please fill out this field.";
        } else {
            loginPage.usernameBox.sendKeys(username);
        }
    }

    @When("User enters invalid {string} or leaves the input blank password")
    public void userEntersInvalidOrLeavesTheInputBlankPassword(String password) {
        if (password.isEmpty() || password.isBlank()) {
            expectedErrorMessage = "Please fill out this field.";
        } else {
            loginPage.passwordBox.sendKeys(password);
        }
    }

    @When("User clicks on login button")
    public void userClicksOnLoginButton() {
        loginPage.loginButton.click();
        if (expectedErrorMessage.equals("Please fill out this field.")) {
            Alert alert = Driver.getDriver().switchTo().alert();
            actualErrorMessage = alert.getText();
        }else {
            actualErrorMessage = loginPage.errorMessage.getText();
        }
    }

    @Then("User shouldn't be able to login and should see error message")
    public void userShouldnTBeAbleToLoginAndShouldSeeErrorMessage() {
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }
}
