package casino.mga;

import app.AppConfig;
import casino.A_BaseTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;

public class AdminTests extends A_BaseTest {

    @Test
    public void loginToAdmin() {
        app.adminPage.open(AppConfig.ADMIN_URL);
        app.adminPage.login(AppConfig.ADMIN_login, AppConfig.ADMIN_password);
        app.adminPage.topPanel.shouldHave(text(AppConfig.ADMIN_login));
    }
}
