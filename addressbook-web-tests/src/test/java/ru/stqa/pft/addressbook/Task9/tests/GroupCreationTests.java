package ru.stqa.pft.addressbook.Task9.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Task9.model.GroupData;

public class GroupCreationTests extends TestBase {

    @Test

    public void testGroupCreation() {
        app.getNavigationHelper().gotoGroupsPage();
        app.getGroupHelper().createGroup(new GroupData("tst1", null, null));
    }

}