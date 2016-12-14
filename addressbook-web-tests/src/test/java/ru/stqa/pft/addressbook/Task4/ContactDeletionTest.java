package ru.stqa.pft.addressbook.Task4;

import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {

    @Test
    public void testContactDeletion() {
        gotoHomePage();
        selectContact();
        deleteContact();
    }
}
