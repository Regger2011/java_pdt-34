package ru.stqa.pft.addressbook.Task12.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Task12.model.ContactData;
import ru.stqa.pft.addressbook.Task12.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void insurePreconditionsForContacts () {
        app.goTo().contactPage();
        if (app.contact().list().size() == 0) {
            app.goTo().addContact();
            app.contact().create(new ContactData().withFirstname("Firstname").withLastname("Lastname").withGroup("[none]"));
        }
    }

    @Test (enabled = true)
    public void testContactDeletion() {
        Contacts before=app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        Contacts after = app.contact().all();
        assertEquals(after.size(),before.size()-1);
        assertThat(after , equalTo(before.without(deletedContact)));
    }
}