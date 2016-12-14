package ru.stqa.pft.addressbook.Task5.tests;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

   @Test

    public void testGroupDeletion() {
       app.getNavigationHelper().gotoGroupsPage();
       app.getGroupHelper().selectGroup();
       app.getGroupHelper().deleteSelectedGroup();
       app.getGroupHelper().returnToGroupPage();
    }
}
