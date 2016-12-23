package ru.stqa.pft.addressbook.Task10.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Task10.model.GroupData;

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
            app.getGroupHelper().fillGroupForm(new GroupData("tEsT1", "tEsT2", "tEsT3"));
            app.getGroupHelper().submitUpdateGroupModification();
            app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
            Assert.assertEquals(after.size(), before.size());
    }
}
