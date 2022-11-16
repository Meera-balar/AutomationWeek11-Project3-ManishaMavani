package herokuapptest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class MicrosoftEdgeBrowserTest {
    //Main method declaration
    public static void main(String[] args) {
        //herokuapp url is stored in variable baseUrl
        String baseUrl = "http://the-internet.herokuapp.com/login";
        //setup key-value for edge browser
        System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
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





