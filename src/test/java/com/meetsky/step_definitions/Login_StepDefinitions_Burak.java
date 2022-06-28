package com.meetsky.step_definitions;

import com.meetsky.pages.LoginPage_Burak;
import com.meetsky.utilities.ConfigurationReader;
import com.meetsky.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_StepDefinitions_Burak {

    protected LoginPage_Burak loginPageBurak = new LoginPage_Burak();
    private String expectedErrorMessage = ConfigurationReader.getProperty("error_message_for_invalid");
    private String actualErrorMessage = "";
    private int i = 0;
    /*
    @param: "i" is used to indicate which case block will be executed in the
    userShouldnTBeAbleToLoginAndShouldSeeErrorMessage() method
    */

    @Given("User goes to login page")
    public void userGoesToLoginPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("login_page_url"));
    }

    @When("User enters {string} username")
    public void userEnters(String username) {
        if (username.isEmpty() || username.isBlank()) {
            changeExpectedErrorMessageForEmpty(1);
        } else {
            loginPageBurak.usernameBox.sendKeys(username);
        }
    }


    @And("User enters {string} password")
    public void userEntersPassword(String password) {
        if (password.isEmpty() || password.isBlank()) {
            changeExpectedErrorMessageForEmpty(2);
        } else {
            loginPageBurak.passwordBox.sendKeys(password);
        }
    }

    @When("User clicks on login button")
    public void userClicksOnLoginButton() {
        loginPageBurak.loginButton.click();
    }

    @Then("User shouldn't be able to login and should see error message")
    public void userShouldnTBeAbleToLoginAndShouldSeeErrorMessage() {
        switch (i) {
            case 0:
                actualErrorMessage = Driver.getDriver().findElement(By.xpath("//p[contains(text(),'Wrong username or password.')]")).getText();
                break;
            case 1:
                WebElement username = new WebDriverWait(Driver.getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.id("user")));
                actualErrorMessage = username.getAttribute("validationMessage");
                break;
            case 2:
                WebElement password = new WebDriverWait(Driver.getDriver(), 20).until(ExpectedConditions.elementToBeClickable(By.id("password")));
                actualErrorMessage = password.getAttribute("validationMessage");
                break;
        }
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }


    @Then("User should be logged in")
    public void userShouldBeLoggedIn() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("apps/files"));
    }

    @Then("User should see the password in a form of dots")
    public void userShouldSeeThePasswordInAFormOfDots() {
        Assert.assertEquals("password", loginPageBurak.passwordBox.getAttribute("type"));
    }

    @And("User clicks on eye icon")
    public void userClicksOnEyeIcon() {
        loginPageBurak.showPassword.click();
    }

    @Then("User should see the password in a form of text")
    public void userShouldSeeThePasswordInAFormOfText() {
        Assert.assertEquals("text", loginPageBurak.passwordBox.getAttribute("type"));
    }

    @When("User clicks on Forgot password link")
    public void userClicksOnLink() {
        loginPageBurak.forgotPassword.click();
    }

    @Then("User should see the Reset Password button")
    public void userShouldSeeTheButton() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(By.id("reset-password-submit"))));
        Assert.assertTrue(Driver.getDriver().findElement(By.id("reset-password-submit")).isDisplayed());
    }

    @When("User sees the {string} and {string} placeholders")
    public void userSeesTheAndPlaceholders(String usernamePlaceholder, String passwordPlaceholder) {
        Assert.assertEquals(usernamePlaceholder, loginPageBurak.usernameBox.getAttribute("placeholder"));
        Assert.assertEquals(passwordPlaceholder, loginPageBurak.passwordBox.getAttribute("placeholder"));
    }

    private void changeExpectedErrorMessageForEmpty(int a) {
        expectedErrorMessage = ConfigurationReader.getProperty("error_message_for_empty");
        i = a;
    }
}