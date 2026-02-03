package SuiteCRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity6 {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set FirefoxDriver path if not using WebDriverManager
        System.setProperty("webdriver.Firefox.driver", "path/to/FirefoxDriver");

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open application
        driver.get("http://alchemy.hguy.co/crm");

        // Login
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();
    }

    @Test
    public void verifyActivitiesMenuExistsAndClickable() {
        // Locate Activities menu
        WebElement activitiesMenu = driver.findElement(By.xpath("//a[text()='Activities']"));

        // Verify menu is displayed
        Assert.assertTrue(activitiesMenu.isDisplayed(), "Activities menu is not displayed");

        // Verify menu is enabled (clickable)
        Assert.assertTrue(activitiesMenu.isEnabled(), "Activities menu is not clickable");

        // Click on Activities menu
        activitiesMenu.click();

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
