package ru.stqa.pft.addressbook.Task4;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        gotoAddContactPage();
        fillContactForm(new ContactData("firstname", "middlename", "lastname", "company", "address", "telephoneMobile", "telephoneWork", "email", "homepage"));
        submitContactCreation();
        gotoHomePage();
    }
}