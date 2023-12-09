package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchCustomerPage {

    WebDriver driver;

    public SearchCustomerPage(WebDriver rdriver) {
        driver = rdriver;
        PageFactory.initElements(rdriver,this);
    }

    @FindBy(id ="SearchEmail")
    WebElement emailAdd;

    @FindBy(id = "search-customers")
    WebElement searchBtn;

    @FindBy(xpath = "//table[@role='grid']")
    WebElement searchResult;

    @FindBy(xpath = "//table[@id='customers-grid']//tbody/tr")
    List<WebElement> tableRows;

    /* @FindBy(xpath = "//table[@id='customers-grid']//tbody/tr[1]/td")
    List<WebElement> tableColumns; */

    @FindBy(id="SearchFirstName")
    WebElement firstName;

    @FindBy(id="SearchLastName")
    WebElement lastName;

    // Action method to enter email Address
    public void enterEmailAdd(String email){
        emailAdd.sendKeys(email);
    }

    //action method to perform click action on search button
    public void clickOnSearchButton(){
        searchBtn.click();
    }

    public boolean searchCustomerByEmail(String email){
        boolean found = false;

        //total no. of rows in a grid
        int ttlRows = tableRows.size();


        for(int i=1;i<=ttlRows;i++) // to iterate all the rows of the grid
        {
            WebElement webElementEmail = driver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[" + i  + "]/td[2]"));
            String actualEmailAdd = webElementEmail.getText();
            if(actualEmailAdd.equals(email)){
                found = true;
            }
        }
        return found;

    }

    ////////////// Search Customer by Name//////////////////
    // Action method to enter first Name
    public void enterFirstName(String firstNameText){
        firstName.sendKeys(firstNameText);
    }

    // Action method to enter last name
    public void enterLastname(String firstLastText){
        lastName.sendKeys(firstLastText);
    }

    public boolean searchCustomerByName(String name){
        boolean found = false;

        //total no. of rows in a grid
        int ttlRows = tableRows.size();


        for(int i=1;i<=ttlRows;i++) // to iterate all the rows of the grid
        {
            WebElement webElementName = driver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[" + i  + "]/td[3]"));
            String actualName = webElementName.getText();
            if(actualName.equals(name)){
                found = true;
                break;
            }
        }
        return found;

    }

}