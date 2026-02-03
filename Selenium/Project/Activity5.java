package SuiteCRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity5 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // a. Open a browser
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        // b. Navigate to the site
        driver.get("https://alchemy.hguy.co/crm/");

        // Login using provided credentials
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();

        // Wait for homepage to load
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getNavigationMenuColor() {

        // c. Get the navigation menu color
        WebElement navigationMenu = driver.findElement(By.id("toolbar"));
        String navColor = navigationMenu.getCssValue("background-color");

        // Print color to console
        System.out.println("Navigation Menu Color: " + navColor);
    }

    @AfterMethod
    public void tearDown() {
        // d. Close the browser
        driver.quit();
    }
}
