package ru.stqa.pft.addressbook.Task10.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Task10.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test

    public void testContactCreation() {
        app.getNavigationHelper().gotoAddContactPage();
        app.getContactHelper().createContact(new ContactData("Firstname", null,null,null,null,null,null,null,null, "[none]"),true);
        app.getNavigationHelper().gotoHomePage();
    }
}