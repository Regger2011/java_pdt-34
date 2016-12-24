package ru.stqa.pft.addressbook.Task11.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Task11.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void insurePreconditionsForGroups () {
        app.getNavigationHelper().gotoGroupsPage();
        app.getGroupHelper().checkAnyGroupPresent();
    }

    @Test
    public void testGroupDeletion() {
       List<GroupData> before=app.getGroupHelper().getGroupList();
       int index = before.size() - 1;
       app.getGroupHelper().deleteGroup(index);
       List<GroupData> after = app.getGroupHelper().getGroupList();
       before.remove(index);
       Assert.assertEquals (new HashSet<Object>(before),new HashSet<Object>(after));
    }
}
