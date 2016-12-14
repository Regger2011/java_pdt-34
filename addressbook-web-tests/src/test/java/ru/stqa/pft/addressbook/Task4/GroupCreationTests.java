package ru.stqa.pft.addressbook.Task4;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        gotoGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("tst1", "tst2", "tst3"));
        submitGroupCreation();
        returnToGroupPage();
    }

}