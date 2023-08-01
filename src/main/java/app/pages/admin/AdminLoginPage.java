package app.pages.admin;

import app.pages.BasePage;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AdminLoginPage extends BasePage {
    public AdminLoginPage(String pageUrl) {
        super(pageUrl);
    }

    public SelenideElement adminLogin = $x(".//input[@name='uName']");
    public SelenideElement adminPassword = $x(".//input[@name='uPass']");
    public SelenideElement submitButton = $x(".//input[@name='login']");
    public SelenideElement topPanel = $(".topTD");
    public void login(String login, String password) {
        adminLogin.setValue(login);
        adminPassword.setValue(password);
        submitButton.click();
        System.out.println();
    }


}
