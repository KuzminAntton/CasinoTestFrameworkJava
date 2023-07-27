package app.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import helpers.Driver;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends BasePage {

    public SelenideElement loginButton = $x("(//*[@data-tracker-name='/login'])[1]");
    public SelenideElement loginField = $("#uName");
    public SelenideElement passwordField = $("#uPass");
    public SelenideElement signInButton = $x("(//button[@type='submit'])[2]");

    public SelenideElement userIcon = $("#user_icon");

    public LoginPage(String pageUrl) {
        super(pageUrl);
    }

    public void login(String email, String password) {
        loginButton.click();
        loginField.setValue(email);
        passwordField.setValue(password);
        signInButton.click();
        userIcon.shouldBe(Condition.visible);
//        Driver.waitForUrlContains("secure");
    }
}
