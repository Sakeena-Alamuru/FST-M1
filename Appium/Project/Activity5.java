package Project;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Activity5 {

	 AndroidDriver driver;
	@Test
	public void testValidLogin() {

	    driver.get("https://training-support.net/webelements");
	    driver.findElement(By.xpath("//h2[text()='Login Form']")).click();

	    driver.findElement(By.id("username")).sendKeys("admin");
	    driver.findElement(By.id("password")).sendKeys("password");

	    driver.findElement(By.xpath("//button[text()='Submit']")).click();

	    String successMessage = driver.findElement(By.id("action-confirmation")).getText();

	    Assert.assertEquals(successMessage, "Login Success!");
	}

	@Test
	public void testInvalidLogin() {

	    driver.get("https://training-support.net/webelements");
	    driver.findElement(By.xpath("//h2[text()='Login Form']")).click();

	    driver.findElement(By.id("username")).sendKeys("admin");
	    driver.findElement(By.id("password")).sendKeys("wrongpassword");

	    driver.findElement(By.xpath("//button[text()='Submit']")).click();

	    String failureMessage = driver.findElement(By.id("action-confirmation")).getText();

	    Assert.assertEquals(failureMessage, "Invalid Credentials");
	}

	
}
