package app.pages.admin.tabs;

import app.pages.BasePage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

public class UsersTabPage extends BasePage {
    public UsersTabPage(String pageUrl) {
        super(pageUrl);
    }

    // this variable is using to understand that user added to admin
    // and 2 is number of mentions users emails in admin table
    private final int expectedNumberOfEmailMentions = 2;

    public boolean isUserExist(String userEmail) {
        ElementsCollection usersEmailMentions = $$(By.xpath(".//a[contains(text(), '" + userEmail + "')]"));

        return usersEmailMentions.size() == expectedNumberOfEmailMentions;
    }
}
