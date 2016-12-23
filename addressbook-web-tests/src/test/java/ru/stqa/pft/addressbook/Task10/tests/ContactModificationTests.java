package ru.stqa.pft.addressbook.Task10.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Task10.model.ContactData;

public class ContactModificationTests extends TestBase {
    @Test
    public void testContactModification (){
        app.getNavigationHelper().gotoHomePage();
        int before = app.getContactHelper().getContactCount();
        if (! app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().gotoAddContactPage();
            app.getContactHelper().createContact(new ContactData("Firstname", null, null, null, null, null, null, null, null, "[none]"), true);
        }
        if (before > 0) {
        app.getNavigationHelper().selection(before-1);
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("FirstnamE", "MiddlenamE", "LastnamE", "CompanY", "AddresS", "TelephoneMobilE", "TelephoneWorK", "EmaiL", "HomepagE", null),false);
        app.getContactHelper().submitUpdateContactModification();
        app.getContactHelper().returnToHomePage();
        int after = app.getContactHelper().getContactCount();
            Assert.assertEquals(after, before);
        }
    }
}
