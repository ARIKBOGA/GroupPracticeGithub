package com.meetsky.pages;

import com.meetsky.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FilesPage {

    @FindBy(xpath = "//div[@id='uploadprogresswrapper']/../a")
    public WebElement plusIcon;

    @FindBy(xpath = "(//span[@class='displayname'])[3]")
    public WebElement newTextDocumentLink;

    @FindBy(id = "view13-input-file")
    public WebElement fileNameInput;

    @FindBy(xpath = "//input[@class='icon-confirm']")
    public WebElement archerButton;

    @FindBy(xpath = "//body/div[@id='viewer-content']/div[1]/div[2]/button[1]")
    public WebElement XButton;

    @FindBy(xpath = "//tr[@data-type='dir']")
    public List<WebElement> foldersList;

    @FindBy(xpath = "//tr[@data-type='file']")
    public List<WebElement> filesList;

    @FindBy(xpath = "//span[@class='dirinfo']")
    public WebElement folderInfo;

    @FindBy(xpath = "//span[@class='fileinfo']")
    public WebElement fileInfo;

    public FilesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


}
