package ru.stqa.pft.addressbook.Task9.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Task9.model.ContactData;

public class ContactModificationTests extends TestBase {
    @Test
    public void testContactModification (){
        app.getNavigationHelper().gotoHomePage();
        checkAnyContactPesentsAndCreateIfNO();
        app.getNavigationHelper().selection();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("FirstnamE", "MiddlenamE", "LastnamE", "CompanY", "AddresS", "TelephoneMobilE", "TelephoneWorK", "EmaiL", "HomepagE", null),false);
        app.getContactHelper().submitUpdateContactModification();
        app.getContactHelper().returnToHomePage();
    }
}
