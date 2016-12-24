package ru.stqa.pft.addressbook.Task10.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Task10.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test

    public void testContactCreation() {
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> before=app.getContactHelper().getContactList();
        app.getNavigationHelper().gotoAddContactPage();
        ContactData contact = new ContactData("Firstname", null,null,null,null,null,null,null,null, "[none]");
        app.getContactHelper().createContact(contact);
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> after=app.getContactHelper().getContactList();
        //before.add(before.size() + 1);
        //Assert.assertEquals(after,before);
        Assert.assertEquals(after.size(),before.size()+1);

        int max=0;
        for (ContactData c : after) {
            if (c.getId() > max) {
                max  = c.getId();
            }
        }
        contact.setId(max);
        before.add(contact);
        Assert.assertEquals (new HashSet<Object>(before),new HashSet<Object>(after));
    }
}