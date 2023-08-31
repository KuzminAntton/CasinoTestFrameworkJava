package app.pages.admin;

import app.pages.BasePage;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AdminLoginPageSTG extends BasePage {
    public AdminLoginPageSTG(String pageUrl) {
        super(pageUrl);
    }

    public SelenideElement adminLogin = $x(".//*[contains(@class, 'sb-user')]/ancestor::div[contains(@class, 'field-box')]//input");
    public SelenideElement adminPassword = $x(".//*[contains(@class, 'sb-locked')]/ancestor::div[contains(@class, 'field-box')]//input");
    public SelenideElement submitButton = $x(".//*[contains(@class, 'log-in-btn')]");

    public void login(String login, String password) {
        adminLogin.setValue(login);
        adminPassword.setValue(password);
        submitButton.click();
    }


}
