package com.meetsky.step_definitions;

import com.meetsky.pages.FilesPage;
import com.meetsky.pages.LoginPage;
import com.meetsky.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class fileSummary {

    private static WebDriver driver;
    private final LoginPage loginPage = new LoginPage();
    private final FilesPage filesPage = new FilesPage();


    @Given("I should be logged in as a user with credentials {string} and {string}")
    public void i_should_be_logged_in_as_a_user_with_credentials_and(String username, String password) {
        Driver.getDriver().get("https://qa.meetsky.net/index.php/login");
        loginPage.login(username, password);
    }

    @Given("I am on the dashboard page")
    public void i_am_on_the_dashboard_page() {
        System.out.println(Driver.getDriver().getTitle());
        Assert.assertEquals(Driver.getDriver().getTitle(), "Files - Meetsky - QA");
    }

    @Given("Click to  plus icon")
    public void click_to_plus_icon() {
        filesPage.plusIcon.click();
    }

    @Given("Click to New text document link")
    public void click_to_new_text_document_link() {
        filesPage.newTextDocumentLink.click();
    }

    @Given("Enter the {string} to the File name field \\(with extension)")
    public void enter_the_to_the_file_name_field_with_extension(String fileName) {
        filesPage.fileNameInput.clear();
        filesPage.fileNameInput.sendKeys(fileName);
    }

    @When("Press enter from keyboard and Click to X button on the file edit page")
    public void press_enter_from_keyboard_and_click_to_x_button_on_the_file_edit_page() {
        filesPage.fileNameInput.sendKeys(Keys.ENTER);
        filesPage.XButton.click();
    }

    @Then("Check if the file summary footer numbers are correct")
    public void check_if_the_file_summary_footer_numbers_are_correct() {

        int filesCount = filesPage.filesList.size();
        int foldersCount = filesPage.foldersList.size();

        int fileCountFooter = Integer.parseInt(filesPage.fileInfo.getText().substring(0, 1));
        int folderCountFooter = Integer.parseInt(filesPage.folderInfo.getText().substring(0, 1));

        System.out.println("filesCount = " + filesCount);
        System.out.println("fileCountFooter = " + fileCountFooter);
        System.out.println("foldersCount = " + foldersCount);
        System.out.println("folderCountFooter = " + folderCountFooter);

        Assert.assertTrue((filesCount == fileCountFooter) && (foldersCount == folderCountFooter));

        Driver.closeDriver();
    }

}