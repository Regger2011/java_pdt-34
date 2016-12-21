package ru.stqa.pft.addressbook.Task10.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

   @Test

    public void testGroupDeletion() {
       app.getNavigationHelper().gotoGroupsPage();
       int before = app.getGroupHelper().getGroupCount();
       app.getGroupHelper().checkAnyGroupPresent();
       app.getNavigationHelper().selection();
       app.getGroupHelper().deleteSelectedGroup();
       app.getGroupHelper().returnToGroupPage();
       int after = app.getGroupHelper().getGroupCount();
       Assert.assertEquals(after,before + 1);
    }
}
