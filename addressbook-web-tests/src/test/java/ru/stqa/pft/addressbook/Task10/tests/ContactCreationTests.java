package ru.stqa.pft.addressbook.Task10.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Task10.model.ContactData;

import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test

    public void testContactCreation() {
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> before=app.getContactHelper().getContactList();
        app.getNavigationHelper().gotoAddContactPage();
        app.getContactHelper().createContact(new ContactData("Firstname", null,null,null,null,null,null,null,null, "[none]"));
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> after=app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(),before.size() + 1);
    }
}