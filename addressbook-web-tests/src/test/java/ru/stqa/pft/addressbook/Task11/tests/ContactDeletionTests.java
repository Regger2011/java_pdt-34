package ru.stqa.pft.addressbook.Task11.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Task11.model.ContactData;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

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
        List<ContactData> before=app.contact().list();
        int index = before.size() - 1;
        app.contact().delete(index);
        List<ContactData> after = app.contact().list();
        before.remove(index);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(after, before);
        Assert.assertEquals (new HashSet<Object>(before),new HashSet<Object>(after));
    }
}