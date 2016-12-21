package ru.stqa.pft.addressbook.Task10.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    @Test

    public void testContactDeletion() {

        app.getNavigationHelper().gotoHomePage();
        //app.getContactHelper().checkAnyContactPresent();
        checkAnyContactPesentsAndCreateIfNO();
        app.getNavigationHelper().selection();
        app.getContactHelper().deleteContact();
        app.getNavigationHelper().gotoHomePage();
    }

}