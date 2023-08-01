package app.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import helpers.Trim;
import io.qameta.allure.Allure;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AdminPage extends BasePage{
    public AdminPage(String pageUrl) {
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
