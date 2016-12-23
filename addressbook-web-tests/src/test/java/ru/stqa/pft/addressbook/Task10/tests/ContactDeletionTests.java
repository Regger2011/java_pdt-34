package ru.stqa.pft.addressbook.Task10.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Task10.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {
    @Test

    public void testContactDeletion() {
        app.getNavigationHelper().gotoHomePage();
        if (! app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().gotoAddContactPage();
            app.getContactHelper().createContact(new ContactData("Firstname", null,null,null,null,null,null,null,null, "[none]"));
        }
        List<ContactData> before=app.getContactHelper().getContactList();
        app.getNavigationHelper().selection(before.size()-1);
        app.getContactHelper().deleteContact();
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
            Assert.assertEquals(after.size(), before.size() - 1);
    }
}