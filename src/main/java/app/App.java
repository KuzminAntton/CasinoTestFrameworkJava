package app;

import app.pages.AdminPage;
import app.pages.LoginPage;

public class App {

    public LoginPage loginPage;
    public AdminPage adminPage;

    public App() {
        loginPage = PageBuilder.buildLoginPage();
        adminPage = PageBuilder.buildAdminPage();
    }
}
