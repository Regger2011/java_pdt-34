package ru.stqa.pft.addressbook.Task11.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Task11.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void insurePreconditionsForContacts () {
        app.getNavigationHelper().gotoHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().gotoAddContactPage();
            app.getContactHelper().createContact(new ContactData("Firstname", null, null, null, null, null, null, null, null, "[none]"));
        }
    }

    @Test (enabled = false)
    public void testContactDeletion() {
        List<ContactData> before=app.getContactHelper().getContactList();
        app.getNavigationHelper().selection(before.size()-1);
        app.getContactHelper().deleteContact();
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        before.remove(before.size() - 1);
        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(after, before);
        Assert.assertEquals (new HashSet<Object>(before),new HashSet<Object>(after));
    }
}