package ru.stqa.pft.addressbook.Task7.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Task7.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test

    public void testContactCreation() {
        app.getNavigationHelper().gotoAddContactPage();
        app.getContactHelper().fillContactForm(new ContactData("firstname", "middlename", "lastname", "company", "address", "telephoneMobile", "telephoneWork", "email", "homepage"));
        app.getContactHelper().submitContactCreation();
        app.getNavigationHelper().gotoHomePage();
    }
}