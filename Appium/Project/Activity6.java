package Project;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Activity6 {
	AndroidDriver driver;
	@Test
	public void testPopupLogin() {

	    driver.get("https://training-support.net/webelements");
	    driver.findElement(By.xpath("//h2[text()='Popups']")).click();

	    // Open login popup
	    driver.findElement(By.xpath("//button[text()='Sign In']")).click();

	    driver.findElement(By.id("username")).sendKeys("admin");
	    driver.findElement(By.id("password")).sendKeys("password");

	    driver.findElement(By.xpath("//button[text()='Submit']")).click();

	    String successMessage = driver.findElement(By.id("action-confirmation")).getText();

	    Assert.assertEquals(successMessage, "Login Success!");
	}

}
