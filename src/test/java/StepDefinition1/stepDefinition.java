//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package StepDefinition1;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class stepDefinition extends BaseClass {

    @Given("User Launch Edge Browser")
    public void user_launch_edge_browser() {
        WebDriverManager.edgedriver().setup();
        this.driver = new EdgeDriver();
        this.loginPg = new LoginPage(this.driver);
        this.addNewCustPg = new AddNewCustomerPage(this.driver);
        SearchCustPg = new SearchCustomerPage(driver);
    }

    @When("user opens URL {string}")
    public void user_opens_url(String url) {
        this.driver.get(url);
    }

    @When("user enter Email as {string} and Password as {string}")
    public void user_enter_email_as_and_password_as(String emailadd, String password) {
        this.loginPg.enterEmail(emailadd);
        this.loginPg.enterPassword(password);
    }

    @When("Click on Login")
    public void click_on_login() {
        this.loginPg.clickOnLoginButton();
    }

    @Then("Page Title should be {string}")
    public void page_title_should_be(String expectedTitle) {
        String actualTitle = this.driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

    }

    @When("User click on Log out link")
    public void user_click_on_log_out_link() {

        loginPg.clickOnLogOutButton();
    }

    @Then("Close browser")
    public void close_browser() {
        this.driver.close();
        this.driver.quit();
    }

    @Then("User can view Dashboard")
    public void user_can_view_dashboard() {
        String actualTitle = this.addNewCustPg.getPageTitle();
        String expectedTitle = "Dashboard / nopCommerce administration";
        if (actualTitle.equals(expectedTitle)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

    }

    @When("User click on customers Menu")
    public void user_click_on_customers_menu() {
        this.addNewCustPg.clickOnCustomersMenu();
        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    @When("click on customers menu Items")
    public void click_on_customers_menu_items() {
        this.addNewCustPg.clickOnCustomersMenuItem();
        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    @When("click on Add new button")
    public void click_on_add_new_button() {
        this.addNewCustPg.clickOnAddnew();
    }

    @Then("User can view Add new Customer Page")
    public void user_can_view_add_new_customer_page() {
        String actualTitle = this.addNewCustPg.getPageTitle();
        String expectedTitle = "Add a new customer / nopCommerce administration";
        if (actualTitle.equals(expectedTitle)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

    }

    @When("user enter customer info")
    public void user_enter_customer_info() {
        //this.addNewCustPg.enterEmail("cdq671@gmail.com");
        addNewCustPg.enterEmail(generateEmailId() + "@gmail.com");
        this.addNewCustPg.enterPassword("test1");
        this.addNewCustPg.enterFirstName("Bobby");
        this.addNewCustPg.enterLastName("Tripathi");
        this.addNewCustPg.enterGender("Female");
        this.addNewCustPg.enterDob("11/27/2001");
        this.addNewCustPg.enterCompanyName("Nokia");
        this.addNewCustPg.enterAdminContent("Admin Content");
        this.addNewCustPg.enterManagerOfVendor("Vendor 1");
    }

    @When("click on Save button")
    public void click_on_save_button() {
        this.addNewCustPg.clickOnSave();
    }

    @Then("User can view confirmation message {string}")
    public void user_can_view_confirmation_message(String expectedConfirmationMsg) {
        String bodyTagText = this.driver.findElement(By.tagName("Body")).getText();
        if (bodyTagText.contains(expectedConfirmationMsg)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

    }

    //// Search Customer Page//////////
    @When("Enter customer Email")
    public void enter_customer_email(){
            SearchCustPg.enterEmailAdd("victoria_victoria@nopCommerce.com");
    }
    @When("Click on search button")
    public void click_on_search_button() {
            SearchCustPg.clickOnSearchButton();
        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    @Then("User should found Email in the Search table")
    public void user_should_found_email_in_the_search_table() {
            String expectedEmail = "victoria_victoria@nopCommerce.com";
            //Assert.assertTrue(SearchCustPg.searchCustomerByEmail(expectedEmail));
            if(SearchCustPg.searchCustomerByEmail(expectedEmail)==true){
                Assert.assertTrue(true);
            }else{
                Assert.assertTrue(false);
            }
    }

    //////////////// Search Customer by Name/////////////////////
    @When("Enter customer FirstName")
    public void enter_customer_first_name() {
        SearchCustPg.enterFirstName("Victoria");
    }
    @When("Enter customer LastName")
    public void enter_customer_last_name() {
        SearchCustPg.enterLastname("Terces");
    }
    @Then("User should found Name in the Search table")
    public void user_should_found_name_in_the_search_table() {
        String expectedName = "Victoria Terces";
        if(SearchCustPg.searchCustomerByName(expectedName)==true){
            Assert.assertTrue(true);
        }else{
            Assert.assertTrue(false);
        }
    }


}

