package app.pages.stg77;

import app.pages.BasePage;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.SelenideWait;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class LoginPageSTG extends BasePage {

    public SelenideElement loginButton = $(".sign-in-box");
    public SelenideElement loginField = $x(".//*[contains(@class, 'sb-user')]/ancestor::div[contains(@class, 'field-box')]//input");
    public SelenideElement passwordField = $x(".//*[contains(@class, 'sb-locked')]/ancestor::div[contains(@class, 'field-box')]//input");
    public SelenideElement signInButton = $x(".//*[contains(@class, 'log-in-btn')]");

    public SelenideElement profileButton = $x(".//*[contains(@class, 'profile-btn')]");

    public SelenideElement loginErrorMessage = $x(".//*[contains(@title, 'Dismiss this notification')]");

    public SelenideElement loginFormatError = $("#uName-error");

    public SelenideElement userIcon = $("#user_icon");

    public LoginPageSTG(String pageUrl) {
        super(pageUrl);
    }

    public void login(String email, String password) throws InterruptedException {
        loginButton.click();
        loginField.setValue(email);
        passwordField.setValue(password);
        signInButton.click();
    }

    public void clickProfileButton() {
        profileButton.click();
    }



    public boolean isLoginErrorMessageDisplayed() {
        return loginErrorMessage.waitUntil(visible, 5000).isDisplayed();
    }

    public boolean isLoginFormatErrorMessageDisplayed() {
        return loginFormatError.waitUntil(visible, 5000).isDisplayed();
    }

}
