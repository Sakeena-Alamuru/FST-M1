package Project;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.URL;
import java.util.List;

public class Activity4 {

    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("deviceName", "Android Device");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
        driver.get("https://training-support.net/webelements");
    }

    @Test
    public void testToDoList() throws InterruptedException {

        // Open To-Do List page
        driver.findElement(By.xpath("//h2[text()='To-Do List']")).click();

        WebElement inputField = driver.findElement(By.xpath("//input[@placeholder='Add a new task']"));

        // Add tasks
        inputField.sendKeys("Add tasks to list");
        inputField.sendKeys("\n");

        inputField.sendKeys("Get number of tasks");
        inputField.sendKeys("\n");

        inputField.sendKeys("Clear the list");
        inputField.sendKeys("\n");

        // Get all tasks (2 existing + 3 new)
        List<WebElement> tasks = driver.findElements(By.xpath("//ul/li"));

        // Assertion for total count
        Assert.assertEquals(tasks.size(), 5);

        // Strike all tasks
        for (WebElement task : tasks) {
            task.click();
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}



