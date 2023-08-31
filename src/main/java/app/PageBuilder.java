package app;

import app.pages.admin.AdminLoginPageSTG;
import app.pages.admin.AdminMainPageSTG;
import app.pages.stg77.LoginPageSTG;

public class PageBuilder {

    public static LoginPageSTG buildLoginPageSTG() {
        return new LoginPageSTG("");
    }

    public static AdminLoginPageSTG buildAdminLoginPage() {
        return new AdminLoginPageSTG("");
    }

    public static AdminMainPageSTG buildAdminMainPage() {
        return new AdminMainPageSTG("campaigns/leaderboard");
    }

}
