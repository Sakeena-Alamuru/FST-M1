package SuiteCRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://alchemy.hguy.co/crm/ ");
		System.out.println("Title of the page is:" + driver.getTitle());
		
		driver.findElement(By.linkText("SuiteCRM"));
        

        // Close the browser
        driver.quit();
		}

}



