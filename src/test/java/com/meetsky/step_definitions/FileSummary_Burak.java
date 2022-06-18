package com.meetsky.step_definitions;

import com.meetsky.pages.FilesPage_Burak;
import com.meetsky.pages.LoginPage_Burak;
import com.meetsky.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class FileSummary_Burak {

    private final LoginPage_Burak loginPageBurak = new LoginPage_Burak();
    private final FilesPage_Burak filesPageBurak = new FilesPage_Burak();


    @Given("I should be logged in as a user with credentials {string} and {string}")
    public void i_should_be_logged_in_as_a_user_with_credentials_and(String username, String password) {

        Driver.getDriver().get("https://qa.meetsky.net/index.php/login");
        loginPageBurak.login(username, password);
    }

    @Given("I am on the dashboard page")
    public void i_am_on_the_dashboard_page() {
        System.out.println(Driver.getDriver().getTitle());
        Assert.assertEquals(Driver.getDriver().getTitle(), "Files - Meetsky - QA");
    }

    @When("Click to  plus icon")
    public void click_to_plus_icon() {
        filesPageBurak.plusIcon.click();
    }

    @When("Click to New text document link")
    public void click_to_new_text_document_link() {
        filesPageBurak.newTextDocumentLink.click();
    }

    @When("Enter the {string} to the File name field \\(with extension)")
    public void enter_the_to_the_file_name_field_with_extension(String fileName) {
        filesPageBurak.fileNameInput.clear();
        filesPageBurak.fileNameInput.sendKeys(fileName);
    }

    @When("Press enter from keyboard and Click to X button on the file edit page")
    public void press_enter_from_keyboard_and_click_to_x_button_on_the_file_edit_page() {
        filesPageBurak.fileNameInput.sendKeys(Keys.ENTER);
        filesPageBurak.XButton.click();
    }

    @Then("Check if the file summary footer numbers are correct")
    public void check_if_the_file_summary_footer_numbers_are_correct() {

        int filesCount = filesPageBurak.filesList.size();
        int foldersCount = filesPageBurak.foldersList.size();

        int fileCountFooter = Integer.parseInt(filesPageBurak.fileInfo.getText().substring(0, 1));
        int folderCountFooter = Integer.parseInt(filesPageBurak.folderInfo.getText().substring(0, 1));

        System.out.println("filesCount = " + filesCount);
        System.out.println("fileCountFooter = " + fileCountFooter);
        System.out.println("foldersCount = " + foldersCount);
        System.out.println("folderCountFooter = " + folderCountFooter);

        Assert.assertTrue((filesCount == fileCountFooter) && (foldersCount == folderCountFooter));


    }
}