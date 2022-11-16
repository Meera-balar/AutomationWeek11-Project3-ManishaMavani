package herokuapptest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class FirefoxBrowserTest {
    //Main method declaration
    public static void main(String[] args) {
        //herokuapp url is stored in variable baseUrl
        String baseUrl = "http://the-internet.herokuapp.com/login";
        //setup key-value for Firefox browser
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        //Launch the Url
        driver.get(baseUrl);
        //maximize window
        driver.manage().window().maximize();
        //We give implicit time to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //get the title
        System.out.println("Page title is : " + driver.getTitle());
        //get the current url
        System.out.println("Page current Url is : "+ driver.getCurrentUrl());
        //Get the page source
        System.out.println("Page source is : " + driver.getPageSource());
        //find the username field element
        WebElement usernameField = driver.findElement(By.id("username"));
        //Enter the username to username field
        usernameField.sendKeys("ManishaM");
        //find the password field element
        WebElement passwordField = driver.findElement(By.id("password"));
        //Enter the password to password field
        passwordField.sendKeys("Mani12345");
        //close the browser
        driver.quit();

    }
}
