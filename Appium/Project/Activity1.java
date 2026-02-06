package Project;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Activity1 {
	
	// Driver Declaration
    AndroidDriver driver;
	WebDriverWait wait;

 // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException, URISyntaxException {
    	UiAutomator2Options options = new UiAutomator2Options();
    	options.setPlatformName("Android");
    	options.setAutomationName("UiAutomator2");
    	options.setAppPackage("com.app.todolist");
    	options.setAppActivity("com.app.todolist.view.MainActivity");
    	options.noReset();

    	// Server Address
        URL serverURL = new URI("http://localhost:4723").toURL();

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
    
    	
    	

    	 wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    }

    @Test
    public void addTasksAndVerify() {

        addTask("Complete Activity 1", "High");
        addTask("Complete Activity 2", "Medium");
        addTask("Complete Activity 3", "Low");

        List<WebElement> tasks =
                driver.findElements(By.id("com.app.todolist:id/task_name"));

        Assert.assertTrue(tasks.stream().anyMatch(t -> t.getText().equals("Complete Activity 1")));
        Assert.assertTrue(tasks.stream().anyMatch(t -> t.getText().equals("Complete Activity 2")));
        Assert.assertTrue(tasks.stream().anyMatch(t -> t.getText().equals("Complete Activity 3")));
    }

    private void addTask(String name, String priority) {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.app.todolist:id/fab_add"))).click();

        driver.findElement(By.id("com.app.todolist:id/task_name")).sendKeys(name);

        driver.findElement(By.id("com.app.todolist:id/priority_spinner")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='" + priority + "']")).click();

        driver.findElement(By.id("com.app.todolist:id/save_task")).click();
    }

}

