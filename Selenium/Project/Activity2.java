package SuiteCRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Activity2 {

    @Test
    public void getHeaderImageUrl() {

        // a. Open a browser
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        // b. Navigate to the URL
        driver.get("https://alchemy.hguy.co/crm/");

        // c. Get the header image element (logo)
        WebElement headerImage = driver.findElement(
                By.xpath("//img[contains(@src,'logo')]")
        );

        // d. Get and print the URL of the header image
        String imageUrl = headerImage.getAttribute("src");
        System.out.println("Header Image URL: " + imageUrl);

        // e. Close the browser
        driver.quit();
    }
}