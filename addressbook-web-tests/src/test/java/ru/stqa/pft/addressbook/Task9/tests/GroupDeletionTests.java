package ru.stqa.pft.addressbook.Task9.tests;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

   @Test

    public void testGroupDeletion() {
       app.getNavigationHelper().gotoGroupsPage();
       app.getNavigationHelper().selection();
       app.getGroupHelper().deleteSelectedGroup();
       app.getGroupHelper().returnToGroupPage();
    }
}
