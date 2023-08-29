package helpers;

import app.AppConfig;
import com.codeborne.selenide.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class Driver {

    private static String driverPath = "driver/";

    public static void initDriver() throws MalformedURLException {
//        String seleniumHubUrl = "http://localhost:4444/wd/hub";
//        URL hubUrl = new URL(seleniumHubUrl);
        System.setProperty("webdriver.chrome.driver", "driver/ubuntu_driver/chromedriver");
//        System.setProperty("webdriver.chrome.driver", "driver/macos_driver/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--lang=en_US");
        options.addArguments("--no-sandbox");
//        options.addArguments("--headless=new");
//        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--ignore-certificate-errors");
//        options.addArguments("--allow-running-insecure-content");
//        options.addArguments("--disable-blink-features=AutomationControlled");

//        options.addArguments("--user-agent=Mozilla/5.0 (X11; Ubuntu; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/116.0.5845.96 Safari/537.36");

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        WebDriver driver = new ChromeDriver(options);
        WebDriverRunner.setWebDriver(driver);

        System.out.println(" driver OPTIONS : " + options);

////        options.addArguments("--headless");
////        options.addArguments("--disable-gpu");
////        options.addArguments("--window-size=1920x1080");
////        options.addArguments("disable-blink-features=AutomationControlled");
//
//
//                .addArguments("--remote-allow-origins=*")
//                .addArguments("--lang=en_US")
//                .addArguments("--no-sandbox")
//                .addArguments("--headless=new")
//                .addArguments("--disable-dev-shm-usage")
//                .addArguments("--ignore-certificate-errors")
//                .addArguments("--allow-running-insecure-content")
//                .addArguments("disable-blink-features=AutomationControlled");
//
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//        capabilities.setCapability("useAutomationExtension", false);
//        capabilities.setCapability("acceptInsecureCerts", true);
//
//        // Configure Selenide to use the remote WebDriver
//        Configuration.remote = hubUrl.toString();
////        Configuration.headless = true;
//        Configuration.driverManagerEnabled= true;
//        Configuration.browser = "chrome"; // Set the browser name
//        Configuration.browserCapabilities = capabilities;
        }
//        else {

//            System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver");
//
//            ChromeOptions options = new ChromeOptions()
//                    .addArguments("--remote-allow-origins=*")
//                    .addArguments("--lang=en_US")
//                    .addArguments("--no-sandbox")
//                    .addArguments("--headless=new")
//                    .addArguments("--disable-dev-shm-usage")
//                    .addArguments("start-maximized")
//                    .addArguments("--ignore-certificate-errors")
//                    .addArguments("--allow-running-insecure-content")
//                    .addArguments("disable-blink-features=AutomationControlled");
//
////            Configuration.pageLoadStrategy = "eager";
////            Configuration.browserSize = "1920x1080";
////            Configuration.holdBrowserOpen = false;
////            Configuration.screenshots = false;
//
////            Configuration.headless = TestConfig.isHeadless();
//
//            switch (TestConfig.browser)
//            {
//                case "chrome":
//                    Configuration.browser = Browsers.CHROME;
//                    WebDriver webDriver = new ChromeDriver(options);
//                    setWebDriver(webDriver);
//                    break;
//                case "firefox":
//                    Configuration.browser = Browsers.FIREFOX;
//                    break;
//                default:
//                    Configuration.browser = Browsers.CHROME;
//                    break;
//            }
//        }
//
//    }

    public static WebDriver currentDriver() {
        return WebDriverRunner.getSelenideDriver().getWebDriver();
    }

    public static void open(String url) {
        Selenide.open(url);
    }

    public static void refresh() {
        Selenide.refresh();
    }

    public static void executeJs(String script) {
        JavascriptExecutor js = (JavascriptExecutor)currentDriver();
        try {
            js.executeScript(script);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void waitForUrlContains(String urlChunk) {
        WebDriverWait wait = new WebDriverWait(currentDriver(), 10);
        wait.until(ExpectedConditions.urlContains(urlChunk));
    }

    public static void waitForUrlDoesNotContain(String urlChunk) {
        int maxTime = 20;
        while(  currentDriver().getCurrentUrl().contains(urlChunk)  && maxTime > 0) {
            wait(1);
            maxTime--;
        }
    }

    public static void maximize() {
        currentDriver().manage().window().maximize();
    }

    public static void changeWindowSize(int width, int height) {
        currentDriver().manage().window().setSize(new Dimension(width, height));
    }

    public static void clearCookies(String URL) {
        open(URL);
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

    public static void close() {
        currentDriver().quit();
    }

    public static void wait(int seconds)
    {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void takeScreenshot() {

        File scrFile = ((TakesScreenshot) currentDriver()).getScreenshotAs(OutputType.FILE);

        String path = System.getProperty("user.dir")
                + File.separator + "test-output"
                + File.separator + "screenshots"
                + File.separator + " " + "screenshot_" +  (new SimpleDateFormat("HHmmssSSS").format(new Date())) + ".png";
        try {
            FileUtils.copyFile(scrFile, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<LogEntry> getBrowserLogs() {
        LogEntries log = currentDriver().manage().logs().get("browser");
        List<LogEntry> logList = log.getAll();
        return logList;
    }

    public static String getCurrentURL() {
        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }

    // COOKIES

    public static void addCookie(Cookie cookie) {
        currentDriver().manage().addCookie(cookie);
    }

    public static Cookie getCookie(String cookieName) {
        return currentDriver().manage().getCookieNamed(cookieName);
    }

    public static void deleteCookie(String cookieName) {
        currentDriver().manage().deleteCookieNamed(cookieName);
    }

}
