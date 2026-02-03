package SuiteCRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// a. Open a browser
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        // b. Navigate to the URL
        driver.get("https://alchemy.hguy.co/crm/");

        // c. Get the first copyright text in the footer
        WebElement copyrightText = driver.findElement(By.id("admin_options"));
        
        //d. Print the text to the console. 
        System.out.println("The first copyright text in the footer : " + copyrightText.getText() );
     // Close the browser
        driver.quit();
    
	}

}
