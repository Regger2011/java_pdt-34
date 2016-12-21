package ru.stqa.pft.addressbook.Task10.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Task10.model.GroupData;

public class GroupModificationTests extends TestBase {
    @Test
    public void testGroupModification (){
        app.getNavigationHelper().gotoGroupsPage();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test", null, null));
        }
        app.getGroupHelper().createGroup(new GroupData("tEsT1", "tEsT2", "tEsT3"));
    }
}