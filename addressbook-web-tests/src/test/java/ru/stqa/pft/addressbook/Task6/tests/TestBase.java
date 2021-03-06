package ru.stqa.pft.addressbook.Task6.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.Task6.appmanager.AppManager;

public class TestBase {

    protected final AppManager app = new AppManager();

    @BeforeMethod
    public void setUp() throws Exception {
        app.init();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }

}
