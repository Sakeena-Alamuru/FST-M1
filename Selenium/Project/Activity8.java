package SuiteCRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Activity8 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {

        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Open CRM and login
        driver.get("http://alchemy.hguy.co/crm");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_name")))
                .sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();
    }

    @Test
    public void printOddRows() {

        // Navigate to Sales -> Accounts
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Sales']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Accounts']"))).click();

        // Wait for the table to be visible
        WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table[contains(@class,'list view table-responsive')]")
        ));

        // Get all rows from tbody
        List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));

        System.out.println("Printing first 5 odd-numbered rows (1st, 3rd, 5th, ...):");

        int count = 0;
        for (int i = 0; i < rows.size() && count < 5; i += 2) { // odd-numbered rows
            WebElement row = rows.get(i);
            // Column 3 usually contains Account Name
            String accountName = row.findElement(By.xpath(".//td[3]")).getText();
            System.out.println("Row " + (i + 1) + ": " + accountName);
            count++;
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
