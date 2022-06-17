package com.meetsky.step_definitions;

import com.meetsky.pages.LoginPage;
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

    private LoginPage loginPage = new LoginPage();
    private String expectedErrorMessage = "Wrong username or password.";
    private String actualErrorMessage = "";
    private int i = 0;

    @Given("User goes to login page")
    public void userGoesToLoginPage() {
        Driver.getDriver().get("https://qa.meetsky.net/index.php/login");
    }

    @When("User enters {string} username")
    public void userEnters(String username) {
        if (username.isEmpty() || username.isBlank()) {
            expectedErrorMessage = "Please fill out this field.";
            i = 1;
        } else {
            loginPage.usernameBox.sendKeys(username);
        }
    }


    @And("User enters {string} password")
    public void userEntersPassword(String password) {
        if (password.isEmpty() || password.isBlank()) {
            expectedErrorMessage = "Please fill out this field.";
            i = 2;
        } else {
            loginPage.passwordBox.sendKeys(password);
        }
    }

    @When("User clicks on login button")
    public void userClicksOnLoginButton() {
        loginPage.loginButton.click();
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
}