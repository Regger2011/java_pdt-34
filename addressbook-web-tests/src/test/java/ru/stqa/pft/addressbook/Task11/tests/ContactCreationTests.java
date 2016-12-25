package ru.stqa.pft.addressbook.Task11.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Task11.model.ContactData;
import java.util.List;
import java.util.Set;

public class ContactCreationTests extends TestBase {

    @Test (enabled = true)
    public void testContactCreation() {
        app.goTo().contactPage();
        Set<ContactData> before=app.contact().all();
        app.goTo().addContact();
        ContactData contact = new ContactData().withFirstname("Firstname").withMiddlename("Middlename").withLastname("Lastname").withAddress("Address").withTelephoneMobile("TelephoneMobilE").withEmail("email@email.com").withGroup("[none]");
        app.contact().create(contact);
        app.goTo().contactPage();
        Set<ContactData> after=app.contact().all();
        Assert.assertEquals(after.size(),before.size()+1);
        contact.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(before, after);
    }
}