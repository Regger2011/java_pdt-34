package ru.stqa.pft.addressbook.Task11.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Task11.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> before=app.getContactHelper().getContactList();
        app.getNavigationHelper().gotoAddContactPage();
        ContactData contact = new ContactData("Firstname", null,"Lastname",null,null,null,null,null,null, "[none]");
        app.getContactHelper().createContact(contact);
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> after=app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(),before.size()+1);
        before.add(contact);
        //contact.setId(after.stream().max((c1, c2) -> Integer.compare(c1.getId(), c2.getId())).get().getId());
        //Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
        Assert.assertEquals (new HashSet<Object>(before),new HashSet<Object>(after));
    }
}