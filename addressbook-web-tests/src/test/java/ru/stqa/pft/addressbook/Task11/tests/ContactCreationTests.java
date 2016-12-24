package ru.stqa.pft.addressbook.Task11.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Task11.model.ContactData;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test (enabled = false)
    public void testContactCreation() {
        app.goTo().contactPage();
        List<ContactData> before=app.contact().list();
        app.goTo().addContact();
        ContactData contact = new ContactData("Firstname", null,"Lastname",null,null,null,null,null,null, "[none]");
        app.contact().create(contact);
        app.goTo().contactPage();
        List<ContactData> after=app.contact().list();
        Assert.assertEquals(after.size(),before.size()+1);
        before.add(contact);
        Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
        Assert.assertEquals (new HashSet<Object>(before),new HashSet<Object>(after));
    }
}