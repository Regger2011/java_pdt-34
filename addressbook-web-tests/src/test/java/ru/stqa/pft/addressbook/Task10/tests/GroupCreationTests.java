package ru.stqa.pft.addressbook.Task10.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Task10.model.GroupData;
import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test

    public void testGroupCreation() {
        app.getNavigationHelper().gotoGroupsPage();
        List<GroupData> before=app.getGroupHelper().getGroupList();
        GroupData group = new GroupData("test3", null, null);
        app.getGroupHelper().createGroup(group);
        List<GroupData> after=app.getGroupHelper().getGroupList();
        group.setId(after.stream().max((g1, g2) -> Integer.compare(g1.getId(), g2.getId())).get().getId());
        before.add(group);
        Assert.assertEquals (new HashSet<Object>(before),new HashSet<Object>(after));
    }
}