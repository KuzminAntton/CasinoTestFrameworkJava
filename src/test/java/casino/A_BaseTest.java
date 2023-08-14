package casino;

import app.App;
import app.AppConfig;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Driver;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;

public class A_BaseTest {

    protected App app;
    protected SoftAssert softAssert;
    protected Logger logger;

    @BeforeClass
    public void setUp() throws MalformedURLException {

//        Driver.initBrowserStack();
//        SelenideLogger.addListener("CustomClickListener", new CustomClickListener());
        Driver.initDriver();

        app = new App();
        softAssert = new SoftAssert();

        logger = LogManager.getLogger("");
        DOMConfigurator.configure("src/main/resources/log4j.xml");
    }

    @AfterClass
    public void tearDown() {
        Driver.close();
    }

}
