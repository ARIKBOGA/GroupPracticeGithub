package com.meetsky.pages;

import com.meetsky.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage_Burak extends BasePage {
    public LogOutPage_Burak() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}