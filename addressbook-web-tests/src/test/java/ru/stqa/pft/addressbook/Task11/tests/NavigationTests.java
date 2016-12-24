package ru.stqa.pft.addressbook.Task11.tests;

import org.testng.annotations.Test;

public class NavigationTests extends TestBase {

    @Test (enabled = false)
    public void testNavigation() {
        app.goTo().addContact();
        app.goTo().gotoNextBirthdaysPage();
        app.goTo().gotoPrintAllPage();
        app.goTo().backToPreviousPage();
        app.goTo().gotoPrintPhonesPage();
        app.goTo().backToPreviousPage();
        //app.goTo().gotoMapPage(); // not responding - so excluded
        //app.goTo().backToPreviousPage();
        app.goTo().gotoExportPage();
        app.goTo().gotoImportPage();
        app.goTo().editContact();
        app.goTo().newGroup();
        app.session().logout();
    }
}