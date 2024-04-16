package stepDefinitions;

import ReusableActions_Library.ReusableMethods;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class loginSteps {
    //declare webdriver
    WebDriver driver = null;
    //  Scenario Outline: Login with Valid Credentials
    @Given("^I am on the login page$")
    public void navigate(){
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
    }//end of given method
    @When("^I enter valid Username(.*) in text field$")
    public void typeUserName(String username){
        ReusableMethods.sendKeysMethod(driver,"//*[@id='user-name']",username, "Username Field");
    }//end of when method

    @When("^I enter valid password in text field$")
    public void typePassWord(){
        ReusableMethods.sendKeysMethod(driver,"//*[@id='password']", "secret_sauce","Password field");
    }//end of when method

    @And("^click on the login button$")
    public void clickOnLogin(){
        ReusableMethods.clickMethod(driver,"//*[@id='login-button']", "Login Button");
    }//end of and method

    @Then("^I should be taken to the Inventory page$")
    public void inventoryPage(){
        ReusableMethods.verifyPageTitle(driver,"https://www.saucedemo.com/inventory.html");
    }//end of then method

   //  Scenario: Login with Invalid Credentials
    @Given("^I navigate to the login page$")
    public void navigateTo(){
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
    }//end of given method
    @When("^I enter invalid username$")
    public void typeInvalidUserName(){
        ReusableMethods.sendKeysMethod(driver,"//*[@id='user-name']","usernameTest", "Username Field");
    }//end of when method

    @When("^I type in valid password$")
    public void typeInPassWord(){
        ReusableMethods.sendKeysMethod(driver,"//*[@id='password']", "secret_sauce","Password field");
    }//end of when method

    @And("^click on login$")
    public void clickOnLoginButton(){
        ReusableMethods.clickMethod(driver,"//*[@id='login-button']", "Login Button");
    }//end of and method

    @Then("^I should see an error message indicating invalid credentials$")
    public void errorMessage(){
        ReusableMethods.verifyPageTitle(driver,"https://www.saucedemo.com/inventory.html");
    }//end of then method

    // Close the browser after all scenarios
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }//end of condition
    }//end of after method
}//end of class
