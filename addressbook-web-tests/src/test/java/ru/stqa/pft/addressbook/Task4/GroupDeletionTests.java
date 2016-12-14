package ru.stqa.pft.addressbook.Task4;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

   @Test
    public void testGroupDeletion() {
       gotoGroupPage();
       selectGroup();
       deleteSelectedGroup();
       returnToGroupPage();
    }
}
