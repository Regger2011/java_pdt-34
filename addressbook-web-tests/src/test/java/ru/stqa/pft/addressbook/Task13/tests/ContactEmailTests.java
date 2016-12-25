package ru.stqa.pft.addressbook.Task13.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Task13.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailTests extends TestBase {

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
    @Test
    public void testContactEmail(){
        app.goTo().contactPage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
    }



    private String mergeEmails(ContactData contact) {
        return Arrays.asList(contact.getEmail(),
                contact.getEmail2(),
                contact.getEmail3())
                .stream().filter((s) -> !s.equals(""))
                .map(ContactEmailTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String email) {
        return email.replaceAll("\\s", "");
    }
}