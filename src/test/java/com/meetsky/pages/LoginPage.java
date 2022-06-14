package com.meetsky.pages;

import com.meetsky.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "user")
    private WebElement usernameBox;

    @FindBy(id = "password")
    private WebElement passwordBox;

    @FindBy(id = "submit-form")
    private WebElement loginButton;

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void login(String username, String password) {
        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        loginButton.click();
    }
}
