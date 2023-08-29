package casino.stg77;

import app.App;
import app.AppConfig;
import casino.A_BaseTest;
import helpers.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LogInTests extends A_BaseTest
{
    @Test
    public void loginViaEmail() throws InterruptedException {
        app.loginPageSTG.open(AppConfig.casinoSTG_URL);
        System.out.println("this is URL ******************** : " + Driver.getCurrentURL());
        app.loginPageSTG.login(AppConfig.STG_login, AppConfig.STG_password);
        Assert.assertEquals(Driver.getCurrentURL(), AppConfig.casinoSTG_URL + "profile/transactions");
    }

//    @Test
//    public void loginViaIncorrectEmail() {
//        app.loginPage.open(AppConfig.casinoMGA_URL);
//        app.loginPage.login("someIncorrectEmal@gmail.com", AppConfig.MGA_password);
//        Assert.assertTrue(app.loginPage.isLoginErrorMessageDisplayed(), "Seems error message not displayed");
//    }
//
//    @Test
//    public void loginViaIncorrectPassword() {
//        app.loginPage.open(AppConfig.casinoMGA_URL);
//        app.loginPage.login(AppConfig.MGA_login, "someIncorrectPaswword");
//        Assert.assertTrue(app.loginPage.isLoginErrorMessageDisplayed(), "Seems error message not displayed");
//    }
//
//    @Test
//    public void loginViaIncorrectEmailFormat() {
//        app.loginPage.open(AppConfig.casinoMGA_URL);
//        app.loginPage.login("someIncorrectFormatEmail", AppConfig.MGA_password);
//        Assert.assertTrue(app.loginPage.isLoginFormatErrorMessageDisplayed(), "Seems error message not displayed");
//    }

    @AfterMethod
    public void clearCookies() {
        Driver.clearCookies(AppConfig.casinoMGA_URL);
    }

}
