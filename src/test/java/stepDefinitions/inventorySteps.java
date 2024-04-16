package stepDefinitions;

import ReusableActions_Library.ReusableMethods;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class inventorySteps {
    WebDriver driver = null;
    @Given("^I am on logged into the system$")
    public void loggedIn(){
        //define the path of the chrome driver
        WebDriverManager.chromedriver().setup();
        //setting up chromeoptions
        ChromeOptions options = new ChromeOptions();
        //add the precondition arguments
        options.addArguments("start-maximized","incognito");
        //define the chrome web driver
        driver = new ChromeDriver(options);
        //navigate
        driver.navigate().to("https://www.saucedemo.com/");
        //login with valid username
        ReusableMethods.sendKeysMethod(driver,"//*[@id='user-name']","standard_user", "Username Field");
        //type in valid password
        ReusableMethods.sendKeysMethod(driver,"//*[@id='password']", "secret_sauce","Password field");
        //click login button
        ReusableMethods.clickMethod(driver,"//*[@id='login-button']","login button");
    }//end of given method
    @And("^I am on the inventory page$")
    public void inventoryPage(){
        //verify inventory page
        ReusableMethods.verifyURL(driver,"https://www.saucedemo.com/inventory.html");
    }//end of and method
    @When("^I click on a product$")
    public void clickProduct(){
        //click on product
        ReusableMethods.clickMethod(driver,"//*[@id='item_4_title_link']", "Click product");
    }//end of when method
    @And("^I am directed to the specific product page$")
    public void productPage(){
        //verify product page
        ReusableMethods.verifyURL(driver,"https://www.saucedemo.com/inventory-item.html?id=4");
    }//end of and method
    @Then("^I should see detailed information about the product$")
    public void productDetails(){
        //capture text of product details
        String details = ReusableMethods.captureText(driver,"//*[@class='inventory_details_desc_container']", "product details");
        //verify if product details are present
        if(!details.isEmpty()) {
            System.out.println("Product information is displayed");
        }else{
            System.out.println("Failed to display product information");
        }//end of condition
    }//end of then method

    // Close the browser after all scenarios
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }//end of condition
    }//end of after method

}//end of class
