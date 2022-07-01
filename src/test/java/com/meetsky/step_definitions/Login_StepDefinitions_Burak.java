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
            // make the "i" variable as 1 to change the expected error message
            // for username input-box left blank
            changeExpectedErrorMessage(1);
        } else if (username.length() > 15 || username.length() < 2) {
            // make the "i" variable as 3 to change the expected error message
            // for username input-box length mismatch
            changeExpectedErrorMessage(3);
            loginPageBurak.usernameBox.sendKeys(username);
        } else {
            loginPageBurak.usernameBox.sendKeys(username);
        }
    }


    @And("User enters {string} password")
    public void userEntersPassword(String password) {
        if (password.isEmpty() || password.isBlank()) {
            // make the "i" variable as 1 to change the expected error message
            // for password input-box left blank
            changeExpectedErrorMessage(2);
        } else if (password.length() > 15 || password.length() < 2) {
            // make the "i" variable as 3 to change the expected error message
            // for password input-box length mismatch
            changeExpectedErrorMessage(3);
            loginPageBurak.passwordBox.sendKeys(password);
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
            case 0: // check the error message element's text for invalid entry
            case 3: // check the error message element's text for length mismatch entry
                actualErrorMessage = Driver.getDriver()
                        .findElement(By.xpath("//p[@class='warning wrongPasswordMsg']"))
                        .getText();
                break;
            case 1: // check the USERNAME input-box for getting error message for left blank
                WebElement username = new WebDriverWait(Driver.getDriver(), 20)
                        .until(ExpectedConditions.elementToBeClickable(By.id("user")));
                actualErrorMessage = username.getAttribute("validationMessage");
                break;
            case 2: // check the PASSWORD input-box for getting error message for left blank
                WebElement password = new WebDriverWait(Driver.getDriver(), 20)
                        .until(ExpectedConditions.elementToBeClickable(By.id("password")));
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

    private void changeExpectedErrorMessage(int a) {
        if (a == 3) { // if "a" equals to 3 then change the expected error message for length mismatch
            expectedErrorMessage = ConfigurationReader.getProperty("error_message_for_length_mismatch");
        } else // if "a" equals to 1 or 2 then change the expected error message for input-box that left blank
            expectedErrorMessage = ConfigurationReader.getProperty("error_message_for_empty");
        i = a;
    }
}