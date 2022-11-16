package herokuapptest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Scanner;

public class MultiBrowserTest {
    //herokuapp Url stored in variable baseUrl
    static String baseUrl = "http://the-internet.herokuapp.com/login";
    static WebDriver driver;
    //Main Method declaration
    public static void main(String[] args) {
        //Scanner declaration to take input from user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter browser name : ");
        String browser = scanner.next();
        //close scanner
        scanner.close();
        //try block
        try{
            if(browser.equalsIgnoreCase("chrome")){
                //setup key-value for Chrome browser
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
                driver = new ChromeDriver(); //object creation
            } else if (browser.equalsIgnoreCase("firefox")) {
                //setup key-value for Firefox browser
                System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
                driver = new FirefoxDriver();
            } else if (browser.equalsIgnoreCase("edge")) {
                //setup key-value for edge browser
                System.setProperty("webdriver.edge.driver","drivers/msedgedriver.exe");
                driver = new EdgeDriver();
            }else{
                System.out.println("Wrong browser name entered");
            }

            //Launch the Url
            driver.get(baseUrl);
            //Maximize window
            driver.manage().window().maximize();
            //We give implicit time to driver
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

            //Get the title of page
            System.out.println("Page title is " + driver.getTitle());
            //Get the current Url
            System.out.println("Current Url is "+ driver.getCurrentUrl());
            //Get the page source
            System.out.println("page source is " + driver.getPageSource());
            //Find the username field element
            WebElement usernameField = driver.findElement(By.id("username"));
            //Enter the username to username field
            usernameField.sendKeys("Mavani");
            //Find the password field element
            WebElement passwordField = driver.findElement(By.id("password"));
            //Enter the password to password field
            passwordField.sendKeys("1234Abc");
        }catch (Exception e){ // Catch block to handle nullpointerException
            System.out.println("Please Provide correct browser name " + e);
        }
        //close the browser
       driver.quit();
    }
}
