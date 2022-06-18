package com.meetsky.pages;

import com.meetsky.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_Burak extends BasePage {

    @FindBy(id = "user")
    public WebElement usernameBox;

    @FindBy(id = "password")
    public WebElement passwordBox;

    @FindBy(id = "submit-form")
    public WebElement loginButton;

    @FindBy(xpath = "//a[@class='toggle-password']")
    public WebElement showPassword;

    @FindBy(id = "lost-password")
    public WebElement forgotPassword;

    public LoginPage_Burak() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void login(String username, String password) {
        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        loginButton.click();
    }
}