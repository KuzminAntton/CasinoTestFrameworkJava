package casino.stg77;

import app.App;
import app.AppConfig;
import casino.A_BaseTest;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import helpers.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LogInTests extends A_BaseTest
{
    @Test
    public void loginViaEmail() throws InterruptedException {
        app.loginPageSTG.open(AppConfig.casinoSTG_URL);
        app.loginPageSTG.login(AppConfig.STG_login, AppConfig.STG_password);
        Assert.assertEquals(Driver.getCurrentURL(), AppConfig.casinoSTG_URL + "profile/transactions");
    }

    @Test
    public void loginViaIncorrectIncorrectEmail() throws InterruptedException {
        app.loginPageSTG.open(AppConfig.casinoSTG_URL);
        app.loginPageSTG.login("someIncorrectEmal@gmail.com", AppConfig.STG_password);
        Assert.assertTrue(app.loginPageSTG.isLoginErrorMessageDisplayed(), "Seems error message not displayed");
    }

    @Test
    public void loginViaIncorrectPassword() throws InterruptedException {
        app.loginPageSTG.open(AppConfig.casinoSTG_URL);
        app.loginPageSTG.login(AppConfig.STG_login, "someIncorrectPassord");
        Assert.assertTrue(app.loginPageSTG.isLoginErrorMessageDisplayed(), "Seems error message not displayed");
    }

    @AfterMethod
    public void clearCookies() {
        Driver.clearCookies(AppConfig.casinoMGA_URL);
    }

}
