import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class sauceDemo {
    //define webdriver global variable
    WebDriver driver;

    @BeforeSuite
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        //define webdriver
        driver = new ChromeDriver();
    }//end of Before suite

    @Test(priority=1)
    public void loginWithValidCredentials(){
        //navigate to website
        driver.get("https://www.saucedemo.com/");
        //define username
        WebElement userName = driver.findElement(By.xpath("//*[@id='user-name']"));
        //define password
        WebElement password = driver.findElement(By.xpath("//*[@id='password']"));
        //define login button
        WebElement loginButton = driver.findElement(By.xpath("//*[@id='login-button']"));
        //type in valid username
        userName.sendKeys("standard_user");
        //type in valid password
        password.sendKeys("secret_sauce");
        //click login button
        loginButton.click();
        //define actual url variable
        String actualUrl = driver.getCurrentUrl();
        //define expected url variable
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        //verify user is directed to inventory page
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualUrl, expectedUrl, "Login with valid credentials failed");
        softAssert.assertAll();
    }//end of test 1

    @Test(priority=2)
    public void loginWithInvalidCredentials() throws InterruptedException {
        //navigate to website
        driver.get("https://www.saucedemo.com/");
        //define username
        WebElement userName = driver.findElement(By.xpath("//*[@id='user-name']"));
        //define password
        WebElement password = driver.findElement(By.xpath("//*[@id='password']"));
        //define login button
        WebElement loginButton = driver.findElement(By.xpath("//*[@id='login-button']"));
        //type in valid username
        userName.sendKeys("standarduser");
        //type in valid password
        password.sendKeys("secret_sauce");
        //click login button
        loginButton.click();
        //define error element
        WebElement errorElement = driver.findElement(By.cssSelector("h3"));
        //capture error message text
       String errorMessage = errorElement.getText();
        //verify user received error message
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service", "Error message is not displayed");
        softAssert.assertAll();
    }//end of test 2

    @Test(dependsOnMethods = "loginWithValidCredentials")
    public void addProductToCart(){
        //go to inventory page
        driver.get("https://www.saucedemo.com/inventory.html");
        //select product
        WebElement product = driver.findElement(By.xpath("//*[@id='item_4_title_link']"));
        product.click();
        //click on 'Add to Cart'
        WebElement addToCart = driver.findElement(By.xpath("//*[@id='add-to-cart']"));
        addToCart.click();
        //verify that product is added to cart successfully
        WebElement cart = driver.findElement(By.xpath("//*[@class='shopping_cart_badge']"));
        if(cart.getText().equals("1")) {
            System.out.println("Product was added to cart successfully");
        }else {
            System.out.println("Product was not successfully added");
        }//end of condition
    }//end of test 3

    @Test(dependsOnMethods = "loginWithValidCredentials")
    public void viewProductDetails(){
        //go to inventory page
        driver.get("https://www.saucedemo.com/inventory.html");
        //select product
        WebElement product = driver.findElement(By.xpath("//*[@id='item_4_title_link']"));
        product.click();
        //verify product information is displayed
        WebElement productInformation = driver.findElement(By.xpath("//*[@class='inventory_details_desc_container']"));
        String productInfoDetails = productInformation.getText();
        if(!productInfoDetails.isEmpty()) {
            System.out.println("Product information is displayed");
        }else{
            System.out.println("Failed to display product information");
        }//end of condition
    }//end of test 4

    @Test(dependsOnMethods = "loginWithValidCredentials")
    public void addMultipleProducts() throws InterruptedException {
        //define products on inventory page
        ArrayList<WebElement> products = new ArrayList<>(driver.findElements(By.xpath("//*[@class='inventory_item_name ']")));
        //add multiple products to cart
        for(int i=0; i<products.size() && i<3; i++){
            Thread.sleep(3000);
            //click on product
            products.get(i).click();
            Thread.sleep(3000);
            //click on 'Add to Cart'
            WebElement addToCart = driver.findElement(By.className("btn_inventory"));
            addToCart.click();
            Thread.sleep(5000);
            //navigate back to inventory page
            driver.navigate().back();
        }//end of for loop
        //verify products are added to cart successfully
        WebElement cart = driver.findElement(By.xpath("//*[@class='shopping_cart_badge']"));
        if(cart.getText().equals("3")) {
            System.out.println("Products were added to cart successfully");
        }else {
            System.out.println("Products were not successfully added");
        }//end of condition
    }//end of test 5

}//end of class

