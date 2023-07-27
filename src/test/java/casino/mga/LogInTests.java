package casino.mga;

import app.AppConfig;
import casino.A_BaseTest;
import helpers.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LogInTests extends A_BaseTest
{
    @Test
    public void loginViaEmail() {
            app.loginPage.open(AppConfig.casinoMGA_URL);
            app.loginPage.login(AppConfig.MGA_login, AppConfig.MGA_password);
    }

    @AfterMethod
    public void clearCookies() {
        Driver.clearCookies(AppConfig.casinoMGA_URL);
    }

}
