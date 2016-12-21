package ru.stqa.pft.addressbook.Task10.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Task10.model.GroupData;

public class GroupCreationTests extends TestBase {

    @Test

    public void testGroupCreation() {
        app.getNavigationHelper().gotoGroupsPage();
        app.getGroupHelper().createGroup(new GroupData("tst1", null, null));
    }

}