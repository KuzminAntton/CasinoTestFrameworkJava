package app;

import app.pages.admin.AdminLoginPage;
import app.pages.admin.AdminMainPage;
import app.pages.admin.tabs.UsersTabPage;
import app.pages.mga.LoginPage;

public class PageBuilder {

    public static LoginPage buildLoginPage() {
        return new LoginPage("");
    }

    public static AdminLoginPage buildAdminLoginPage() {
        return new AdminLoginPage("");
    }

    public static AdminMainPage buildAdminMainPage() {
        return new AdminMainPage("campaigns/leaderboard");
    }

    public static UsersTabPage buildUsersTabPage() {
        return new UsersTabPage("users/user/");
    }
}
