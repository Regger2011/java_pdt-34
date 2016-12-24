package ru.stqa.pft.addressbook.Task11.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Task11.model.ContactData;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test (enabled = true)
    public void testContactCreation() {
        app.goTo().contactPage();
        List<ContactData> before=app.contact().list();
        app.goTo().addContact();
        ContactData contact = new ContactData().withFirstname("Firstname").withMiddlename("Middlename").withLastname("Lastname").withAddress("Address").withTelephoneMobile("TelephoneMobilE").withEmail("email@email.com").withGroup("[none]");
        app.contact().create(contact);
        app.goTo().contactPage();
        List<ContactData> after=app.contact().list();
        Assert.assertEquals(after.size(),before.size()+1);
    }
}