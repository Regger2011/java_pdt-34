package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactDeletetionTest extends TestBase {

    @Test
    public void deleteContactDeletetion() {
        gotoHomePage();
        selectContact();
        deleteContact();
    }
}
