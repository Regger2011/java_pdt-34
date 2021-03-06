package ru.stqa.pft.addressbook.Task10.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Task10.model.GroupData;

import java.util.HashSet;
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
       before.remove(before.size() - 1);
       Assert.assertEquals (new HashSet<Object>(before),new HashSet<Object>(after));
    }
}
