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
        app.getNavigationHelper().selection();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("tEsT1", "tEsT2", "tEsT3"));
        app.getGroupHelper().submitUpdateGroupModification();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        if (before > 0) {
            Assert.assertEquals(after, before);
        }
    }
}