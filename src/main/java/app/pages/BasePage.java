package app.pages;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import helpers.Trim;
import io.qameta.allure.Allure;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected String pageUrl;

    public BasePage(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public void open(String URL) {
        String url = Trim.rtrim(URL, "/") + "/" + Trim.ltrim(pageUrl, "/");
        Selenide.open(url);
        Allure.step("open url : " + url);
    }

    public WebDriverWait getWebDriverWait() {
        return new WebDriverWait(WebDriverRunner.getWebDriver(), 10);
    }
}
