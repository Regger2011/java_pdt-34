package ru.stqa.pft.addressbook.Task11.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Task11.model.ContactData;
import ru.stqa.pft.addressbook.Task11.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @Test (enabled = true)
    public void testContactCreation() {
        app.goTo().contactPage();
        Contacts before=app.contact().all();
        app.goTo().addContact();
        ContactData contact = new ContactData()
                .withFirstname("Firstname")
                .withMiddlename("Middlename")
                .withLastname("Lastname")
                .withAddress("Address")
                .withTelephoneMobile("TelephoneMobilE")
                .withEmail("email@email.com")
                .withGroup("[none]");
        app.contact().create(contact);
        //app.goTo().contactPage();
        Contacts after=app.contact().all();
        assertThat(after.size(),equalTo(before.size() +1 ));
        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));

    }
}