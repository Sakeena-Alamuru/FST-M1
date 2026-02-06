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

public class Activity3 {

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


        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Test
    public void loginViaPopup() {

        // Navigate to the page
        driver.get("https://training-support.net/webelements");

        // Scroll and click the Popups card
        WebElement popupsCard = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//h3[text()='Popups']")
                )
        );
        popupsCard.click();

        // Click the button to open the login popup
        WebElement loginPopupButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(text(),'Sign In')]")
                )
        );
        loginPopupButton.click();

        // Enter username and password in the popup
        WebElement usernameField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("username"))
        );
        usernameField.sendKeys("admin");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("password");

        // Click the submit button
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // Assertion for successful login message
        WebElement message = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation"))
        );

        Assert.assertTrue(
                message.getText().toLowerCase().contains("welcome"),
                "Expected login success message was not displayed"
        );
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

