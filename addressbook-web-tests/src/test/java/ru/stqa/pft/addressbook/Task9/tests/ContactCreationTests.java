package ru.stqa.pft.addressbook.Task9.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Task9.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test

    public void testContactCreation() {
        app.getNavigationHelper().gotoAddContactPage();
        app.getContactHelper().fillContactForm(new ContactData("Firstname", null,null,null,null,null,null,null,null, "[none]"),true);
        app.getContactHelper().submitContactCreation();
        app.getNavigationHelper().gotoHomePage();
    }
}