package app.pages;
import app.AppConfig;
import com.codeborne.selenide.Selenide;
import helpers.Trim;
import io.qameta.allure.Allure;

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
}
