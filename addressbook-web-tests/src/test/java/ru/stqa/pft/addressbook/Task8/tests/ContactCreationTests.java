package ru.stqa.pft.addressbook.Task8.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Task8.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test

    public void testContactCreation() {
        app.getNavigationHelper().gotoAddContactPage();
        app.getContactHelper().fillContactForm(new ContactData("firstname", null,null,null,null,null,null,null,null));
        app.getContactHelper().submitContactCreation();
        app.getNavigationHelper().gotoHomePage();
    }
}