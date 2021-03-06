package ru.stqa.pft.addressbook.Task13.tests;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Task13.model.ContactData;
import ru.stqa.pft.addressbook.Task13.model.Contacts;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void insurePreconditionsForContacts () {
        app.goTo().contactPage();
        if (app.contact().allCash().size() == 0) {
            app.goTo().addContact();
            app.contact().create(new ContactData().withFirstname("FirstName").withLastname("LastName").withGroup("[none]"));
        }
    }

    @Test(enabled = true)
    public void testContactModification() {
        Contacts before = app.contact().all();
        ContactData modyfiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(modyfiedContact.getId())
                .withFirstname("FirstNamE")
                .withMiddlename(null)
                .withLastname("LastNamE")
                .withCompany("CompanY")
                .withAddress("AddresS")
                .withTelephoneMobile("TelephoneMobilE")
                .withTelephoneWork(null)
                .withEmail("EmaiL")
                .withHomepage(null);
        app.contact().modify(contact);
        assertEquals(app.contact().count(),before.size());
        Contacts after = app.contact().all();
        assertThat(after, CoreMatchers.equalTo(before.without(modyfiedContact).withAdded(contact)));
    }
}
