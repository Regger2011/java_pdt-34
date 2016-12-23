package ru.stqa.pft.addressbook.Task10.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Task10.model.GroupData;
import java.util.List;

public class GroupDeletionTests extends TestBase {

   @Test

    public void testGroupDeletion() {
       app.getNavigationHelper().gotoGroupsPage();
       app.getGroupHelper().checkAnyGroupPresent();
       List<GroupData> before=app.getGroupHelper().getGroupList();
       app.getNavigationHelper().selection(before.size() - 1);
       app.getGroupHelper().deleteSelectedGroup();
       app.getGroupHelper().returnToGroupPage();
       List<GroupData> after = app.getGroupHelper().getGroupList();
       Assert.assertEquals(after.size(), before.size() - 1);
    }
}
