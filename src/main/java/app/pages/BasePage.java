package app.pages;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import helpers.Trim;
import io.qameta.allure.Allure;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.Wait;

public abstract class BasePage {

    protected String pageUrl;

    public BasePage(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public void open(String URL) throws InterruptedException {
        String url = Trim.rtrim(URL, "/") + "/" + Trim.ltrim(pageUrl, "/");
        Selenide.open(url);
//        Thread.sleep(4000);
        Wait().until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
//        boolean networkRequestsCompleted = new WebDriverWait(WebDriverRunner.getWebDriver(), maxWaitTime)
//                .until(driver -> {
//                    Object result = ((JavascriptExecutor) driver)
//                            .executeScript("return window.performance.getEntries().filter(entry => entry.initiatorType === 'fetch').length === 0");
//                    return result instanceof Boolean && (Boolean) result;
//                });
//        if (networkRequestsCompleted) {
//            System.out.println("Network requests completed within " + maxWaitTime + " seconds.");
//        } else {
//            System.out.println("Network requests did not complete within " + maxWaitTime + " seconds.");
//        }
        Allure.step("open url : " + url);
    }

    public WebDriverWait getWebDriverWait() {
        return new WebDriverWait(WebDriverRunner.getWebDriver(), 10);
    }
}
