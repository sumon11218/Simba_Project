package ReusableActions_Library;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class ReusableMethods {
    static int timeLimit = 10;
    public static WebDriver setUpDriver(){
        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //declare chrome options variable
        ChromeOptions options = new ChromeOptions();
        //maximize for windows
        options.addArguments("start-maximized");
        //define the webdriver
        WebDriver driver = new ChromeDriver(options);
        //return the instance of a driver
        return driver;
    }//end of setUpDriver method

    //method to click on any web element
    public static void clickMethod(WebDriver driver, String xpathValue, String elementName) {
        //define the webdriver wait variable
        WebDriverWait wait = new WebDriverWait(driver, timeLimit);
        try {
            //click on the xpath that was provided in the parameter
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue))).click();
        } catch (Exception e) {
            System.out.println("Unable to click on element " + elementName);
        }//end of try catch for click method
    }//end of clickMethod

    //method to click on any web-eleement
    public static void clickByIndex(WebDriver driver, String xpathValue, int indexNumber, String elementName) {
        //define the webdriver wait variable
        WebDriverWait wait = new WebDriverWait(driver, timeLimit);
        try {
            //click on the xpath that was provided in the parameter
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpathValue))).get(indexNumber).click();
        } catch (Exception e) {
            System.out.println("Unable to click on " + elementName);
        }//end of try catch for click method
    }//end of clickMethod

    //method to submit
    public static void submitMethod(WebDriver driver, String xpathValue, String elementName) {
        //define the webdriver wait variable
        WebDriverWait wait = new WebDriverWait(driver, timeLimit);
        try {
            //click on the xpath that was provided in the parameter
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue))).submit();
        } catch (Exception e) {
            System.out.println("Unable to submit on " + elementName);
        }//end of try catch for submit method
    }//end of clickMethod

    //method of entering value on an input field
    public static void sendKeysMethod(WebDriver driver, String xpathValue, String userValue, String elementName) {
        //define the webdriver wait variable
        WebDriverWait wait = new WebDriverWait(driver, timeLimit);
        try {
            WebElement element =  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue)));
            element.clear();
            element.sendKeys(userValue);
        } catch (Exception e) {
            System.out.println("Unable to type on " + elementName);
        }//end of try catch for entering value on an input field method
    }//end of sendKeys Method

    //method for capturing text from a webelement
    public static String captureText(WebDriver driver, String xpathValue, String elementName) {
        //define the webdriver wait variable
        WebDriverWait wait = new WebDriverWait(driver, timeLimit);
        String result = ""; //create a result variable so you can store the getText information and later return it
        try {
            result =  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue))).getText();
        } catch (Exception e) {
            System.out.println("Unable to capture text on " + elementName);
        }
        return result;
    }//end of captureText

    //method for scrolling into view
    public static void scrollIntoView(WebDriver driver, String xpathValue, String elementName ) {
        //define the webdriver wait variable
        WebDriverWait wait = new WebDriverWait(driver, timeLimit);
        try {
            //define JavascriptExecutor variable
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            //declare Webelement variable
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue)));
            //scroll into view for element
            jse.executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            System.out.println("Unable to scroll into view on " + elementName);
        }//end of try catch for scroll into view method
    }//end of scroll into view method

    //method for mouseHover
    public static void mouseHover(WebDriver driver, String xpathValue, String elementName){
        //define the webdriver wait variable
        WebDriverWait wait = new WebDriverWait(driver, timeLimit);
        try{
            //define actions command
            Actions mouseHover = new Actions(driver);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue)));
            //hover mouse over element
            mouseHover.moveToElement(element).perform();
        }catch(Exception e){
            System.out.println("Unable to hover on "+ elementName);
        }//end of try catch for hover method
    }//end of mouse hover

    //method for selectByVisibleText
    public static void selectByText(WebDriver driver, String xpathValue, String text, String elementName){
        //define the webdriver wait variable
        WebDriverWait wait = new WebDriverWait(driver, timeLimit);
        try {
            //define webelement for select
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue)));
            Select selectText = new Select(element);
            //select dropdown option using visible text
            selectText.selectByVisibleText(text);
        }catch(Exception e){
            System.out.println("Unable to select by visible text on "+ elementName);
        }//end of try catch for selecting my visible text

    }//end of select by visible text method

    //method for switchToTabByIndex
    public static void switchToTabByIndex(WebDriver driver, int indexNumber, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,timeLimit);
        try{
            //store tabs in arraylist
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            //switch tabs by index
            driver.switchTo().window(tabs.get(indexNumber));
        }catch(Exception e){
            System.out.println("Unable to switch to tab by index on " + elementName);
        }//end of try catch for switching tabs by index
    }//end of switch to tab by index method

    //method for scrollByPixel
    public static void scrollByPixelMethod(WebDriver driver, int horizontalPixel, int verticalPixel, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, timeLimit);
        try{
            //define javascript executor
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            //scroll by pixel
            jse.executeScript("scroll(" + horizontalPixel + ", " + verticalPixel + ");");
        }catch(Exception e){
            System.out.println("Unable to scroll by pixel on " + elementName);
        }//end of try catch for scroll by pixel
    }//end of scroll by pixel method

    //method to compare expected vs actual title
    public static void verifyPageTitle(WebDriver driver, String expectedTitle){
        try{
            Thread.sleep(1500);
            System.out.println("Verifying page expected title on");
            String actualTitle = driver.getTitle();
            if(actualTitle.contains(expectedTitle)){
                System.out.println("Title matches for - " + expectedTitle);
            } else {
                System.out.println("Expected doesn't match actual and actual title is " + actualTitle);
            }
        } catch (Exception e) {
            System.out.println("Unable to get page title - " + e);
        }
    }//end of comparing expected vs actual title method

    //method to compare actual vs expected url
    public static void verifyURL(WebDriver driver, String expectedURL){
        try{
            Thread.sleep(1500);
            System.out.println("Verifying page expected title on");
            String actualURL = driver.getCurrentUrl();
            if(actualURL.contains(expectedURL)){
                System.out.println("Title matches for - " + expectedURL);
            } else {
                System.out.println("Expected doesn't match actual and actual title is " + actualURL);
            }
        } catch (Exception e) {
            System.out.println("Unable to get page title - " + e);
        }
    }//end of comparing expected vs actual title method

}//end of class



