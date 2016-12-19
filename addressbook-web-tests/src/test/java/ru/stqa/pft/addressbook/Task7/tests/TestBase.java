package ru.stqa.pft.addressbook.Task7.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.Task7.appmanager.AppManager;
import org.openqa.selenium.remote.BrowserType;

public class TestBase {

    //protected final AppManager app = new AppManager(BrowserType.FIREFOX);
    protected final AppManager app = new AppManager(BrowserType.CHROME);
    //protected final AppManager app = new AppManager(BrowserType.IE);
    @BeforeMethod
    public void setUp() throws Exception {
        app.init();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }

}
