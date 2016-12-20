package ru.stqa.pft.addressbook.Task9.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Task9.model.GroupData;

public class GroupModificationTests extends TestBase {
    @Test
    public void testGroupModification (){
        app.getNavigationHelper().gotoGroupsPage();
        app.getNavigationHelper().selection();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("tEsT1", "tEsT2", "tEsT3"));
        app.getGroupHelper().submitUpdateGroupModification();
        app.getGroupHelper().returnToGroupPage();
    }
}