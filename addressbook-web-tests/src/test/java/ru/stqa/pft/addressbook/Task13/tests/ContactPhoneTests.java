package ru.stqa.pft.addressbook.Task13.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Task13.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {

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

        assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
        assertThat(contact.getEmail(), equalTo(contactInfoFromEditForm.getEmail()));
    }

    private String mergePhones(ContactData contact) {
        return Arrays.asList(contact.getTelephoneHome(), contact.getTelephoneMobile(), contact.getTelephoneWork())
                .stream().filter((s) -> ! s.equals(""))
                .map(ContactPhoneTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String phone) {
        return phone.replaceAll("\\s","").replaceAll("[-()]","");
    }
}
