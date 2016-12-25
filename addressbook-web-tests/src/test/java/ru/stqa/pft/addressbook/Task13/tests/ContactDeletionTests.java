package ru.stqa.pft.addressbook.Task13.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Task13.model.ContactData;
import ru.stqa.pft.addressbook.Task13.model.Contacts;

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
        assertEquals(app.contact().count(),before.size()-1);
        Contacts after = app.contact().all();
        assertThat(after , equalTo(before.without(deletedContact)));
    }
}