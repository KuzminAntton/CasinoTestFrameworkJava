package app;

import app.pages.AdminPage;
import app.pages.LoginPage;

public class PageBuilder {

    public static LoginPage buildLoginPage() {
        return new LoginPage("");
    }

    public static AdminPage buildAdminPage() {
        return new AdminPage("");
    }
}
