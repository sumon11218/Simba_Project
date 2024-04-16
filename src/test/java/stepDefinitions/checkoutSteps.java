package stepDefinitions;

import ReusableActions_Library.ReusableMethods;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class checkoutSteps {
    WebDriver driver = null;
    //  Scenario: Checking out with products in cart
    @Given("^I am logged in to my account$")
    public void loggedIntoAcc(){
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

    @And("^I navigate to the inventory page$")
    public void navigateToInventory(){
        //verify inventory page
        ReusableMethods.verifyURL(driver,"https://www.saucedemo.com/inventory.html");
    }//end of and method

    @And("^I have added products in the cart$")
    public void addProduct(){
        //click product
        ReusableMethods.clickMethod(driver,"//*[@id='item_4_title_link']", "add product");
        //click add to cart
        ReusableMethods.clickMethod(driver,"//*[@id='add-to-cart']", "add to cart");
    }//end of and method

    @And("^I navigate to the my cart page$")
    public void myCart(){
        //click cart icon
        ReusableMethods.clickMethod(driver,"//*[@class='shopping_cart_link']", "my cart");
    }//end of and method
    @And("^I click on ‘Checkout’ button$")
    public void clickCheckOut(){
        //click checkout
        ReusableMethods.clickMethod(driver,"//*[@id='checkout']", "checkout");
    }//end of and method
    @When("^I enter my information$")
    public void enterInfo(){
        //enter first name
        ReusableMethods.sendKeysMethod(driver,"//*[@id='first-name']", "test", "first name field");
        //enter last name
        ReusableMethods.sendKeysMethod(driver,"//*[@id='last-name']", "test", "last name field");
        //enter postal code
        ReusableMethods.sendKeysMethod(driver,"//*[@id='postal-code']", "10001","postal code field");
    }//end of when method
    @And("^click on ‘Continue’ button$")
    public void clickContinue(){
        //click continue
        ReusableMethods.clickMethod(driver,"//*[@id='continue']", "continue button");
    }//end of and method
    @And("^click ‘Finish’$")
    public void clickFinish(){
        //click finish
        ReusableMethods.clickMethod(driver,"//*[@id='finish']", "finish");
    }//end of and method
    @Then("^I should receive a confirmation message$")
    public void successfullyProcessed(){
        //verify confirmation message
        WebElement confirmationMessage = driver.findElement(By.xpath("//*[@class='complete-header']"));
        if(confirmationMessage.isDisplayed()){
            System.out.println("Order confirmation message received");
        } else {
            System.out.println("Order confirmation message not received");
        }//end of condition
    }//end of then method

    //Scenario: Handling Empty Text Fields at Checkout
    @Given("^I have connected to my account$")
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
    @And("^I add products to my cart$")
    public void addProducts(){
        //click product
        ReusableMethods.clickMethod(driver,"//*[@id='item_4_title_link']", "add product");
        //click add to cart
        ReusableMethods.clickMethod(driver,"//*[@id='add-to-cart']", "add to cart");
    }//end of and method

    @And("^I navigate to the cart page$")
    public void myCartPage(){
        //click cart icon
        ReusableMethods.clickMethod(driver,"//*[@class='shopping_cart_link']", "my cart");
    }//end of and method
    @And("^I click on the checkout button$")
        public void clickCheckOutButton(){
        //click checkout
        ReusableMethods.clickMethod(driver,"//*[@id='checkout']", "checkout");
    }//end of and method

    @And("^I am redirected to the 'Checkout: Your Information' page$")
    public void checkoutInfoPage(){
        //verify checkout info page
        ReusableMethods.verifyURL(driver,"https://www.saucedemo.com/checkout-step-one.html");
    }//end of and method

    @When("^I proceed by clicking 'Continue'$")
        public void clickContinueButton(){
        //click continue
        ReusableMethods.clickMethod(driver,"//*[@id='continue']", "continue button");
    }//end of when method

    @Then("^I should receive an error message prompting me to fill in the missing information$")
    public void errorMessage(){
        //verify error message
        WebElement errorMessage = driver.findElement(By.xpath("//*[@class='error-message-container error']"));
        if(errorMessage.isDisplayed()){
            System.out.println("Error message for empty text field is displayed");
        } else {
            System.out.println("Error message for empty text field is not displayed");
        }//end of condition
    }//end of then method

    //Scenario: Proceeding with Empty Cart at Checkout
    @Given("^I am logged into my account$")
    public void loggedInAccount(){
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

    @When("^I go to the my cart page$")
    public void cartPage(){
            //click cart icon
            ReusableMethods.clickMethod(driver,"//*[@class='shopping_cart_link']", "my cart");
    }//end of when method

    @And("^I click on checkout$")
    public void checkOut(){
        //click checkout
        ReusableMethods.clickMethod(driver,"//*[@id='checkout']", "checkout");
    }//end of and method

    @And("^I enter my information in the text fields$")
    public void enterInformation(){
        //enter first name
        ReusableMethods.sendKeysMethod(driver,"//*[@id='first-name']", "test", "first name field");
        //enter last name
        ReusableMethods.sendKeysMethod(driver,"//*[@id='last-name']", "test", "last name field");
        //enter postal code
        ReusableMethods.sendKeysMethod(driver,"//*[@id='postal-code']", "10001","postal code field");
    }//end of and method

    @And("^click on ‘Continue’$")
    public void clickContinueIcon(){
        //click continue
        ReusableMethods.clickMethod(driver,"//*[@id='continue']", "continue button");
    }//end of and method

    @And("^click on ‘Finish’$")
    public void finishClick(){
        //click finish
        ReusableMethods.clickMethod(driver,"//*[@id='finish']", "finish");
    }//end of and method

    @Then("^I should receive an error message indicating an empty cart$")
    public void emptyCartErrorMessage(){
        //verify confirmation message is displayed with empty cart
        WebElement confirmationMessage = driver.findElement(By.xpath("//*[@class='complete-header']"));
        if(confirmationMessage.isDisplayed()){
            System.out.println("Order confirmation message received with empty cart");
        } else {
            System.out.println("Order confirmation message not received with empty cart");
        }
    }//end of then method

    // Close the browser after all scenarios
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }//end of condition
    }//end of after method

}//end of class
