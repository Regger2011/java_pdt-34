package ru.stqa.pft.addressbook.Task5.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Task5.appmanager.BaseHelper;

public class ContactDeletionTests extends TestBase {

    @Test

    public void testContactDeletetion() {
        app.getNavigationHelper().gotoHomePage();
        app.getNavigationHelper().selection();
        app.getContactHelper().deleteContact();
        app.getNavigationHelper().gotoHomePage();
    }
}