package SuiteCRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity7 {
	
    WebDriver driver;
    WebDriverWait wait;
    
    @BeforeClass
    public void setUp() {

        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        // Initialize wait here, AFTER driver is created
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Open CRM and login
        driver.get("http://alchemy.hguy.co/crm");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_name")))
                .sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();
    }


    @Test
    public void readAdditionalInformationPopup() {

        // Navigate to Sales -> Leads
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Sales']")))
                .click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Leads']")))
                .click();

     // Wait for table to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("MassUpdate")));

        // Use more robust XPath for first row icon
        WebElement infoIcon = wait.until(ExpectedConditions.presenceOfElementLocated(
            By.xpath("//table[contains(@class,'list')]/tbody/tr[1]//span[contains(@class,'glyphicon-info-sign')]")
        ));

        // Hover over the icon to trigger popover
        new Actions(driver).moveToElement(infoIcon).pause(Duration.ofSeconds(1)).perform();

        // Wait for popover content
        WebElement popoverContent = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[contains(@class,'popover') and contains(@class,'in')]//div[contains(@class,'popover-content')]")
        ));

        String popupText = popoverContent.getText();
        System.out.println(popupText);


        // Extract phone number
        for (String line : popupText.split("\n")) {
            if (line.toLowerCase().contains("phone")) {
                System.out.println("Phone Number: " + line);
            }
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
