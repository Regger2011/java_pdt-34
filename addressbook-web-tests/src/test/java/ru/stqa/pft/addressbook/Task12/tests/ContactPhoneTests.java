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
        if (app.contact().allCash().size() == 0) {
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
        assertThat(contact.getAddress(), equalTo(cleaned(contactInfoFromEditForm.getAddress())));
        assertThat(contact.getTelephoneHome(), equalTo(cleaned(contactInfoFromEditForm.getTelephoneHome())));
        assertThat(contact.getTelephoneMobile(), equalTo(cleaned(contactInfoFromEditForm.getTelephoneMobile())));
        assertThat(contact.getTelephoneWork(), equalTo(contactInfoFromEditForm.getTelephoneWork()));
        assertThat(contact.getEmail(), equalTo(contactInfoFromEditForm.getEmail()));
    }

    public String cleaned(String phone) {
        return phone.replaceAll("\\s","").replaceAll("[-()]","");
    }
}
