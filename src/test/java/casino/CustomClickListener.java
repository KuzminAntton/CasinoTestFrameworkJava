package casino;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.LogEvent;
import com.codeborne.selenide.logevents.LogEventListener;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class CustomClickListener extends AbstractWebDriverEventListener {

    public void afterClickOn(String description, SelenideElement element) {
        // Log a message after clicking
        System.out.println("Clicked on element: " + description);
    }
}
