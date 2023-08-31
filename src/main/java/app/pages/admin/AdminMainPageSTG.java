package app.pages.admin;

import app.pages.BasePage;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class AdminMainPageSTG extends BasePage {
    public AdminMainPageSTG(String pageUrl) {
        super(pageUrl);
    }

    public SelenideElement profileButton = $x(".//*[contains(@class, 'user-info')]");

    public boolean isUserProfileDisplayed() {
       return profileButton.waitUntil(visible, 5000).isDisplayed();
    }

}
