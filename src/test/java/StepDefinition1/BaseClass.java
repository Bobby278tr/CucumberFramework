package StepDefinition1;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

public class BaseClass {

    public WebDriver driver;
    public LoginPage loginPg;
    public SearchCustomerPage SearchCustPg;
    public AddNewCustomerPage addNewCustPg;

    /////////Generate unique email id
    public String generateEmailId(){
        return (RandomStringUtils.randomAlphabetic(5));
    }
}
