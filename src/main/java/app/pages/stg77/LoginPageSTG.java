package app.pages.stg77;

import app.pages.BasePage;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.SelenideWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPageSTG extends BasePage {

    public SelenideElement loginButton = $(".sign-in-box");
    public SelenideElement loginField = $("#ember38");
    public SelenideElement passwordField = $("#ember39");
    public SelenideElement signInButton = $x(".//*[contains(@class, 'log-in-btn')]");

    public SelenideElement profileButton = $("#ember40");

    public SelenideElement loginErrorMessage = $("#login_error");

    public SelenideElement loginFormatError = $("#uName-error");

    public SelenideElement userIcon = $("#user_icon");

    public LoginPageSTG(String pageUrl) {
        super(pageUrl);
    }

    public void login(String email, String password) {
        loginButton.click();
        loginField.waitUntil(visible, 10000).setValue(email);
        passwordField.setValue(password);
        signInButton.click();
        profileButton.click();
    }



    public boolean isLoginErrorMessageDisplayed() {
        return loginErrorMessage.waitUntil(visible, 5000).isDisplayed();
    }

    public boolean isLoginFormatErrorMessageDisplayed() {
        return loginFormatError.waitUntil(visible, 5000).isDisplayed();
    }

}
