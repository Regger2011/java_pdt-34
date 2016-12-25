package ru.stqa.pft.addressbook.Task13.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.Task13.appmanager.AppManager;

public class TestBase {

    //protected final AppManager app = new AppManager(BrowserType.FIREFOX);
    protected static final AppManager app = new AppManager(BrowserType.CHROME);
    //protected final AppManager app = new AppManager(BrowserType.IE);

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }

}
