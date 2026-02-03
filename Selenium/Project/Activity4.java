package SuiteCRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Activity4 {

    @Test
    public void loginTest() {

        // a. Open the browser
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        // b. Navigate to the site
        driver.get("https://alchemy.hguy.co/crm/");

        // c. Find username and password fields
        WebElement username = driver.findElement(By.id("user_name"));
        WebElement password = driver.findElement(By.id("username_password"));

        // d. Enter login credentials
        username.sendKeys("admin");
        password.sendKeys("pa$$w0rd");

        // e. Click login
        driver.findElement(By.id("bigbutton")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
     // f. Verify that the homepage has opened
        String pageTitle = driver.getTitle();

        if (pageTitle.contains("SuiteCRM")) {
            System.out.println("PASS: Homepage opened successfully.");
            System.out.println("Page Title: " + pageTitle);
        } else {
            System.out.println("FAIL: Homepage did not open.");
            System.out.println("Page Title: " + pageTitle);
        }

        // Close the browser
        driver.quit();
    }
}
