package casino.stg77;

import app.AppConfig;
import casino.A_BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;

public class AdminTests extends A_BaseTest {

    @Test
    public void loginToAdmin() throws InterruptedException {
        app.adminPage.open(AppConfig.ADMIN_URL);
        app.adminPage.login(AppConfig.ADMIN_login, AppConfig.ADMIN_password);
        app.adminPage.topPanel.shouldHave(text(AppConfig.ADMIN_login));
    }

    @Test
    public void searchUserInAdmin() throws InterruptedException {
        app.adminPage.open(AppConfig.ADMIN_URL);
        app.adminPage.login(AppConfig.ADMIN_login, AppConfig.ADMIN_password);
        app.adminPage.topPanel.shouldHave(text(AppConfig.ADMIN_login));
        app.adminMainPage.clickOnUserTab();
    }
}