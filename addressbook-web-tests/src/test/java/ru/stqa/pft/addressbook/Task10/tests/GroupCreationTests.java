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
        GroupData group = new GroupData("test1", null, null);
        app.getGroupHelper().createGroup(group);
        List<GroupData> after=app.getGroupHelper().getGroupList();
        //Assert.assertEquals(after,before);


        int max=0;
        for (GroupData g : after) {
            if (g.getId() > max) {
                max  = g.getId();
            }
        }
        group.setId(max);
        before.add(group);
        Assert.assertEquals (new HashSet<Object>(before),new HashSet<Object>(after));
    }
}