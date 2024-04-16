package stepDefinitions;

import ReusableActions_Library.ReusableMethods;
import io.cucumber.java.After;
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
import org.testng.Assert;

import java.util.List;

public class myCartSteps {
    //declare webdriver
    WebDriver driver = null;
    //  Scenario: Adding Product to Cart
    @Given("^I log into an account$")
    public void logIn(){
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

    @And("^I am on the Inventory page$")
    public void inventoryPage(){
        //verify inventory page
        ReusableMethods.verifyURL(driver,"https://www.saucedemo.com/inventory.html");
    }//end of and method

    @When("^I select a product$")
    public void selectProduct(){
        //click on product
        ReusableMethods.clickMethod(driver,"//*[@id='item_4_title_link']", "Click product");
    }//end of when method

    @And("^click on 'Add to Cart'$")
    public void addToCart(){
        //click add to cart
        ReusableMethods.clickMethod(driver,"//*[@id='add-to-cart']", "add to cart");
    }//end of and method

    @Then("^the product should be added to the cart successfully$")
    public void successfullyAdded(){
        WebElement cart = driver.findElement(By.xpath("//*[@class='shopping_cart_badge']"));
        if(cart.getText().equals("1")) {
            System.out.println("Product was added to cart successfully");
        }else {
            System.out.println("Product was not successfully added");
        }//end of conditions
    }//end of then method

    //Scenario: Removing Product from Cart
    @Given("^I am logged in$")
    public void loggedIn() throws InterruptedException {
        Thread.sleep(2000);
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

    @And("^I have added a product to the cart$")
    public void addedToCart(){
        //click on product
        ReusableMethods.clickMethod(driver,"//*[@id='item_4_title_link']", "Click product");
        //click add to cart
        ReusableMethods.clickMethod(driver,"//*[@id='add-to-cart']", "add to cart");
    }//end of and method

    @When("^I visit the cart page$")
    public void navigateToCartPage(){
        //click cart icon
        ReusableMethods.clickMethod(driver,"//*[@class='shopping_cart_link']", "my cart");
    }//end of when method

    @And("^click on ‘Remove’$")
    public void clickRemove(){
        //click remove
        ReusableMethods.clickMethod(driver,"//*[@id='remove-sauce-labs-backpack']", "remove");
    }//end of and method

    @Then("^the product should be removed from the cart successfully$")
    public void removedSuccessfully(){
        // Verify that the cart badge (indicating the number of items) does not exist
        List<WebElement> cartBadges = driver.findElements(By.cssSelector(".shopping_cart_badge"));
        Assert.assertEquals(cartBadges.size(), 0, "Cart should be empty");

}//end of then method

   // Scenario: Adding Multiple Products to Cart
    @Given("^I have access to my account$")
    public void accountAccess(){
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

    @And("^I am redirected to the Inventory page$")
    public void inventoryPageRedirect(){
        //verify inventory page
        ReusableMethods.verifyURL(driver,"https://www.saucedemo.com/inventory.html");
    }//end of and method

    @When("^I add multiple products to the cart$")
    public void multipleProducts(){
        //add product 1
        ReusableMethods.clickMethod(driver,"//*[@id='add-to-cart-sauce-labs-backpack']", "backpack");
        //add product 2
        ReusableMethods.clickMethod(driver,"//*[@id='add-to-cart-sauce-labs-bike-light']", "bike light");
    }//end of when method

    @Then("^all selected products should be added to the cart$")
    public void addedToMyCart(){
        // Verify if all selected products are added to the cart
        Assert.assertEquals("2", driver.findElement(By.xpath("//*[@class='shopping_cart_badge']")).getText());
        //verify products are added to cart successfully
        WebElement cart = driver.findElement(By.xpath("//*[@class='shopping_cart_badge']"));
        if(cart.getText().equals("2")) {
            System.out.println("Products were added to cart successfully");
        }else {
            System.out.println("Products were not successfully added");
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
