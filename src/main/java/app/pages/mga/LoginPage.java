package app.pages.mga;

import app.pages.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import helpers.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends BasePage {

    public SelenideElement loginButton = $x("(//*[@data-tracker-name='/login'])[1]");
    public SelenideElement loginField = $("#uName");
    public SelenideElement passwordField = $("#uPass");
    public SelenideElement signInButton = $x("(//button[@type='submit'])[2]");

    public SelenideElement loginErrorMessage = $("#login_error");

    public SelenideElement loginFormatError = $("#uName-error");

    public SelenideElement userIcon = $("#user_icon");

    public LoginPage(String pageUrl) {
        super(pageUrl);
    }

    public void login(String email, String password) {
        System.out.println("start login");
        new WebDriverWait(loginButton.getWrappedDriver(), 20).until(ExpectedConditions.visibilityOfAllElements(loginButton));
        loginButton.click();
        loginField.setValue(email);
        passwordField.setValue(password);
        signInButton.click();
//        userIcon.shouldBe(visible);
    }



    public boolean isLoginErrorMessageDisplayed() {
        return loginErrorMessage.waitUntil(visible, 5000).isDisplayed();
    }

    public boolean isLoginFormatErrorMessageDisplayed() {
        return loginFormatError.waitUntil(visible, 5000).isDisplayed();
    }

}
