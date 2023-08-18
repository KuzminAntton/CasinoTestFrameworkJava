package casino.mga;

import app.AppConfig;
import casino.A_BaseTest;
import com.codeborne.selenide.SelenideElement;
import helpers.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;

public class LogInTests extends A_BaseTest
{
    @Test
    public void loginViaEmail() throws InterruptedException {
        app.loginPage.open("https://www.google.com/");
        SelenideElement element = $x(".//*[@alt='Google']");
        Assert.assertTrue(element.isDisplayed());
//        app.loginPage.login(AppConfig.MGA_login, AppConfig.MGA_password);

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
