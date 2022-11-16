package herokuapptest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ChromeBrowserTest {
    //Main method declaration
    public static void main(String[] args) {
        // herokuapp Url stored in variable baseUrl
        String baseUrl = "http://the-internet.herokuapp.com/login";
        //setup key-value for Chrome browser
        System.setProperty("webdriver.chrome.driver" , "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Launch the Url
        driver.get(baseUrl);
        //Maximize window
        driver.manage().window().maximize();
        //We give implicit time to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        // get the page title
        System.out.println("Page title is :  " + driver.getTitle());
        //Get the current Url
        System.out.println("Current url is : " + driver.getCurrentUrl());
        //Get the page source
        System.out.println("page ource is : " + driver.getPageSource());

        //Find the username field element
        WebElement usernameField = driver.findElement(By.id("username"));
        //Enter username to username Field
        usernameField.sendKeys("Manisha");
        //Find the password field element
        WebElement passwordField = driver.findElement(By.id("password"));
        //Enter password to password field
        passwordField.sendKeys("123456");
        //close the browser
        driver.quit();

    }
}
