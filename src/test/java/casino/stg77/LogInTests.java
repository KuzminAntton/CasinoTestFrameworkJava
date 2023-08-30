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
        Thread.sleep(5000);
        System.out.println("this is URL ******************** : " + Driver.getCurrentURL());

        // Print the page source for debugging
        System.out.println("Page source: " + WebDriverRunner.getWebDriver().getPageSource());

        app.loginPageSTG.login(AppConfig.STG_login, AppConfig.STG_password);

        // Take a screenshot for debugging in case of failure
        Selenide.screenshot("failure_screenshot");

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
