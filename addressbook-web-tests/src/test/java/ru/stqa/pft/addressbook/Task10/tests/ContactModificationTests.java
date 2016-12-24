package ru.stqa.pft.addressbook.Task10.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Task10.model.ContactData;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {
    @Test
    public void testContactModification (){
        app.getNavigationHelper().gotoHomePage();
        if (! app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().gotoAddContactPage();
            app.getContactHelper().createContact(new ContactData("Firstname", null, null, null, null, null, null, null, null, "[none]"));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getNavigationHelper().selection(before.size() - 1);
        app.getContactHelper().initContactModification();
        ContactData contact = new ContactData(before.get(before.size() - 1).getId(),"FirstNamE", "MiddlenamE", "LastNamE", "CompanY", "AddresS", "TelephoneMobilE", "TelephoneWorK", "EmaiL", "HomepagE", null);
        app.getContactHelper().fillContactForm(contact, false);
        app.getContactHelper().submitUpdateContactModification();
        app.getContactHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        before.remove(before.size() - 1);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
        Assert.assertEquals (new HashSet<Object>(before),new HashSet<Object>(after));
    }
}
