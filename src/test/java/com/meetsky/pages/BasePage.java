package com.meetsky.pages;

import com.meetsky.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    @FindBy(id = "nextcloud")
    public WebElement homePageLink;

    @FindBy(xpath = "(//ul[@id='appmenu']//a)[1]")
    public WebElement filesPageLink;

    @FindBy(xpath = "(//ul[@id='appmenu']//a)[2]")
    public WebElement photosPageLink;

    @FindBy(xpath = "(//ul[@id='appmenu']//a)[3]")
    public WebElement activityPageLink;

    @FindBy(xpath = "(//ul[@id='appmenu']//a)[4]")
    public WebElement spreedPageLink;

    @FindBy(xpath = "(//ul[@id='appmenu']//a)[5]")
    public WebElement contactsPageLink;

    @FindBy(xpath = "(//ul[@id='appmenu']//a)[6]")
    public WebElement calendarPageLink;

    @FindBy(xpath = "(//ul[@id='appmenu']//a)[7]")
    public WebElement notesPageLink;

    @FindBy(xpath = "(//ul[@id='appmenu']//a)[8]")
    public WebElement tasksPageLink;

    @FindBy(xpath = "//a[@class='header-menu__trigger']")
    public WebElement topRightSearchButton;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement topRightSearchBox;

    @FindBy(xpath = "//div[@class='notifications']")
    public WebElement topRightNotificationButton;

    @FindBy(xpath = "//div[@id='contactsmenu']")
    public WebElement topRightContactsButton;

    @FindBy(xpath = "//input[@id='contactsmenu-search']")
    public WebElement topRightSearchContactsBox;

    @FindBy(xpath = "//div[@id='expand']")
    public WebElement topRightSettingsExpandButton;

    @FindBy(xpath = "//span[@class='user-status-menu-item__header']")
    public WebElement accountMenuUsername;

    @FindBy(xpath = "//a[@class='user-status-menu-item__toggle']")
    public WebElement accountMenuSetStatusButton;

    @FindBy(xpath = "//li[@data-id='settings']/a")
    public WebElement accountMenuSettingsButton;

    @FindBy(xpath = "//li[@data-id='help']/a")
    public WebElement accountMenuHelpButton;

    @FindBy(xpath = "//li[@data-id='logout']/a")
    public WebElement accountMenuLogoutButton;


    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

}