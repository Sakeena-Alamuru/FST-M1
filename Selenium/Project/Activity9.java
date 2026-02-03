package SuiteCRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Activity9 {

    public static void main(String[] args) {

        // a. Open browser and login
        WebDriver driver = new FirefoxDriver();
        
        driver.get("https://alchemy.hguy.co/crm");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("username_password")).submit();

        // b. Navigate to Sales -> Leads
        wait.until(ExpectedConditions.elementToBeClickable(By.id("grouptab_0"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("moduleTab_9_Leads"))).click();

        // c. Find the table and print first 10 Name and User values
        List<WebElement> rows = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(
                        By.xpath("//table[contains(@class,'list view')]//tr[contains(@class,'oddListRowS1') or contains(@class,'evenListRowS1')]")
                )
        );

        System.out.println("Name | User");
        System.out.println("------------");

        for (int i = 0; i < 10 && i < rows.size(); i++) {
            WebElement row = rows.get(i);

            String name = row.findElement(By.xpath(".//td[@field='name']")).getText();
            String user = row.findElement(By.xpath(".//td[@field='assigned_user_name']")).getText();

            System.out.println(name + " | " + user);
        }

        // d. Close the browser
        driver.quit();
    }
}


