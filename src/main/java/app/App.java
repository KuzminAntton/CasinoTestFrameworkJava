package app;

import app.pages.admin.AdminLoginPageSTG;
import app.pages.admin.AdminMainPageSTG;
import app.pages.stg77.LoginPageSTG;

public class App {

    public LoginPageSTG loginPageSTG;

    public AdminLoginPageSTG adminPage;

    public AdminMainPageSTG adminMainPage;

    public App() {
        loginPageSTG = PageBuilder.buildLoginPageSTG();
        adminPage = PageBuilder.buildAdminLoginPage();
        adminMainPage = PageBuilder.buildAdminMainPage();
    }
}
