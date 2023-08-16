package casino;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.URL;

public class SeleniumHealthCheck {


    @Test
    public static void checkSeleniumServerHealth() {
        try {
            // Replace with your Selenium Hub URL
            URL hubUrl = new URL("http://localhost:4444/wd/hub");

            // Set up ChromeOptions
            ChromeOptions options = new ChromeOptions();
            options.setCapability("browserName", "chrome");

            // Create a RemoteWebDriver instance
            WebDriver driver = new RemoteWebDriver(hubUrl, options);

            // Perform a simple action (e.g., get title)
            driver.get("https://www.google.com");
            String title = driver.getTitle();
            System.out.println("Page title: " + title);

            // Close the WebDriver
            driver.quit();

            System.out.println("Selenium Server is up and running.");
        } catch (Exception e) {
            System.err.println("Error: Selenium Server is not reachable.");
            e.printStackTrace();
        }
    }
}
