package Project;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.URI;
import java.net.URL;
import java.time.Duration;

public class Activity2 {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        // Set the Appium server URL
        URL serverURL = new URI("http://localhost:4723").toURL();

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);

        // Open the page in Chrome
        driver.get("https://training-support.net/webelements");

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    
    @Test
    public void loginWithValidCredentials() {

        driver.get("https://training-support.net/webelements");

        // Scroll and open Login Form card
        driver.findElement(By.xpath("//h3[text()='Login Form']")).click();

        // Enter username
        WebElement username = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("username"))
        );
        username.sendKeys("admin");

        // Enter password
        driver.findElement(By.id("password")).sendKeys("password");

        // Submit
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // Assertion for success message
        WebElement successMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation"))
        );

        Assert.assertTrue(
                successMessage.getText().contains("Welcome"),
                "Expected success message was not displayed"
        );
    }
    @Test
    public void loginWithInvalidCredentials() {

        driver.navigate().refresh();

        WebElement username = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("username"))
        );
        username.clear();
        username.sendKeys("admin");

        WebElement password = driver.findElement(By.id("password"));
        password.clear();
        password.sendKeys("wrongpassword");

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // Assertion for error message
        WebElement errorMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation"))
        );

        Assert.assertTrue(
                errorMessage.getText().toLowerCase().contains("invalid"),
                "Expected error message was not displayed"
        );
    }

    
@AfterClass
public void tearDown() {
    if (driver != null) {
        driver.quit();
    }
}
}



