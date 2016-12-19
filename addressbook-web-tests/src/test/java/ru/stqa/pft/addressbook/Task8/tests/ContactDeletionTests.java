package ru.stqa.pft.addressbook.Task8.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    @Test

    public void testContactDeletetion() {
        app.getNavigationHelper().gotoHomePage();
        app.getNavigationHelper().selection();
        app.getContactHelper().deleteContact();
        app.getNavigationHelper().gotoHomePage();
    }
}