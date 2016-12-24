package ru.stqa.pft.addressbook.Task10.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Task10.model.GroupData;
import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase {
    @Test
    public void testGroupModification () {
        app.getNavigationHelper().gotoGroupsPage();
        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test", null, null));
        }
        List<GroupData> before=app.getGroupHelper().getGroupList();
        app.getNavigationHelper().selection(before.size() - 1);
        app.getGroupHelper().initGroupModification();
        GroupData group = new GroupData(before.get(before.size() - 1).getId(),"tEsT1", "tEsT2", "tEsT3");
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitUpdateGroupModification();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        before.remove(before.size() - 1);
        before.add(group);
        Assert.assertEquals (new HashSet<Object>(before),new HashSet<Object>(after));
    }
}
