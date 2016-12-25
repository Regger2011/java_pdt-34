package ru.stqa.pft.addressbook.Task12.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Task12.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase{

    @BeforeMethod
    public void insurePreconditionsForContacts () {
        app.goTo().contactPage();
        if (app.contact().list().size() == 0) {
            app.goTo().addContact();
            app.contact().create(new ContactData()
                    .withFirstname("FirstName")
                    .withLastname("LastName")
                    .withAddress("address")
                    .withTelephoneHome("telephoneHome")
                    .withTelephoneWork("telephoneWork")
                    .withTelephoneMobile("telephoneMobile")
                    .withEmail("email")
                    .withGroup("[none]"));
        }
    }

    @Test (enabled = true)
    public void testContactPhones () {
        app.goTo().contactPage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        assertThat(contact.getTelephoneHome(), equalTo(contactInfoFromEditForm.getTelephoneHome()));
        assertThat(contact.getTelephoneMobile(), equalTo(contactInfoFromEditForm.getTelephoneMobile()));
        assertThat(contact.getTelephoneWork(), equalTo(contactInfoFromEditForm.getTelephoneWork()));
    }
}
