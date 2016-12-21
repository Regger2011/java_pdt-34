package ru.stqa.pft.addressbook.Task10.tests;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

   @Test

    public void testGroupDeletion() {
       app.getNavigationHelper().gotoGroupsPage();
       app.getGroupHelper().checkAnyGroupPresent();
       app.getNavigationHelper().selection();
       app.getGroupHelper().deleteSelectedGroup();
       app.getGroupHelper().returnToGroupPage();
    }
}
