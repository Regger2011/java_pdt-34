package ru.stqa.pft.addressbook.Task13.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Task13.model.ContactData;


import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactInfoTests extends TestBase {
    public void testContactInfo


    @Test(enabled = true)

    {
        app.goTo().contactPage();
        ContactData contact = app.contact().allCash().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        ContactData contactInfoDetails = app.contact().contactInfo(contact);

        assertThat((merge(contactInfoDetails)), equalTo(merge(contactInfoFromEditForm)));
    }

    @BeforeMethod
    public void insurePreconditionsForContacts() {
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
                    .withEmail("email2")
                    .withEmail("email3")
                    .withGroup("[none]"));
        }
    }

    private String merge(ContactData contact) {

        return Arrays.asList(contact.getLastname(),
                contact.getFirstname(),
                contact.getAddress(),
                contact.getTelephoneHome(),
                contact.getTelephoneMobile(),
                contact.getTelephoneWork(),
                contact.getEmail(),
                contact.getEmail2(),
                contact.getEmail3())
                .stream()
                .filter((s) -> !s.equals("")).collect(Collectors.joining("\n"));
    }
}