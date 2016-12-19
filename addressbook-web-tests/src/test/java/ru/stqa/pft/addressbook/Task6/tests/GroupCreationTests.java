package ru.stqa.pft.addressbook.Task6.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Task6.model.GroupData;

public class GroupCreationTests extends TestBase {

    @Test

    public void testGroupCreation() {
        app.getNavigationHelper().gotoGroupsPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("tst1", "tst2", "tst3"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();
    }

}