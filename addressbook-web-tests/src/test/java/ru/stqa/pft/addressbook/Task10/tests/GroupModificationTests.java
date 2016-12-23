package ru.stqa.pft.addressbook.Task10.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Task10.model.GroupData;

public class GroupModificationTests extends TestBase {
    @Test
    public void testGroupModification (){
        app.getNavigationHelper().gotoGroupsPage();
        int before = app.getGroupHelper().getGroupCount();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test", null, null));
        }
        if (before > 0) {
        app.getNavigationHelper().selection(before-1);
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("tEsT1", "tEsT2", "tEsT3"));
        app.getGroupHelper().submitUpdateGroupModification();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupCount();
            Assert.assertEquals(after, before);
        }
    }
}