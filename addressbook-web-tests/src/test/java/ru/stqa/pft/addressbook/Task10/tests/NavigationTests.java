package ru.stqa.pft.addressbook.Task10.tests;

import org.testng.annotations.Test;

public class NavigationTests extends TestBase {

    @Test

    public void testNavigation() {
        app.getNavigationHelper().gotoAddContactPage();
        app.getNavigationHelper().gotoNextBirthdaysPage();
        app.getNavigationHelper().gotoPrintAllPage();
        app.getNavigationHelper().backToPreviousPage();
        app.getNavigationHelper().gotoPrintPhonesPage();
        app.getNavigationHelper().backToPreviousPage();
        //app.getNavigationHelper().gotoMapPage(); // not responding - so excluded
        //app.getNavigationHelper().backToPreviousPage();
        app.getNavigationHelper().gotoExportPage();
        app.getNavigationHelper().gotoImportPage();
        app.getNavigationHelper().gotoEditGroupsPage();
        app.getNavigationHelper().gotoNewGroupsPage();
        app.getSessionHelper().logout();
    }
}