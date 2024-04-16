package stepDefinitions;

import ReusableActions_Library.ReusableMethods;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class logoutSteps {
    //declare webdriver
    WebDriver driver = null;
    @Given("^I am logged into the system$")
    public void login(){
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

    @When("^I click on the logout button$")
        public void logout() throws InterruptedException {
        //click on menu
        ReusableMethods.clickMethod(driver,"//*[@id='react-burger-menu-btn']","menu");
        Thread.sleep(3000);
        //click on logout
        ReusableMethods.clickMethod(driver,"//*[@id='logout_sidebar_link']", "logout button");
    }//end of when method

    @Then("^I should be redirected to the login page$")
    public void loginPageRedirect(){
        ReusableMethods.verifyPageTitle(driver, "Swag Labs");
    }//end of then method

    // Close the browser after all scenarios
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }//end of condition
    }//end of after method
}//end of class
