package app;

import app.pages.admin.AdminLoginPage;
import app.pages.admin.AdminMainPage;
import app.pages.admin.tabs.UsersTabPage;
import app.pages.mga.LoginPage;

public class App {

    public LoginPage loginPage;
    public AdminLoginPage adminPage;

    public AdminMainPage adminMainPage;

    public UsersTabPage usersTabPage;

    public App() {
        loginPage = PageBuilder.buildLoginPage();
        adminPage = PageBuilder.buildAdminLoginPage();
        adminMainPage = PageBuilder.buildAdminMainPage();
        usersTabPage = PageBuilder.buildUsersTabPage();
    }
}
