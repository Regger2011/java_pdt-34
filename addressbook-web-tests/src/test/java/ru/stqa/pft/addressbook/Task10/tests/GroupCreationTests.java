package ru.stqa.pft.addressbook.Task10.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Task10.model.GroupData;
import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test

    public void testGroupCreation() {
        app.getNavigationHelper().gotoGroupsPage();
        List<GroupData> before=app.getGroupHelper().getGroupList();
        app.getGroupHelper().createGroup(new GroupData("tst1", null, null));
        List<GroupData> after=app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(),before.size() + 1);
    }

}