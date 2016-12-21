package ru.stqa.pft.addressbook.Task9.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.Task9.appmanager.AppManager;
import ru.stqa.pft.addressbook.Task9.model.ContactData;

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

    protected void checkAnyContactPesentsAndCreateIfNO() {
        if (! app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().gotoAddContactPage();
            app.getContactHelper().createContact(new ContactData("Firstname", null,null,null,null,null,null,null,null, "[none]"),true);
        }
    }
}
