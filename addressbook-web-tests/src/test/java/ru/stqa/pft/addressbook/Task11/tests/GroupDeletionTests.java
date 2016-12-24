package ru.stqa.pft.addressbook.Task11.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Task11.model.GroupData;
import java.util.List;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void insurePreconditionsForGroups () {
        app.goTo().groupPage();
        app.group().create(new GroupData().withName("test1"));
    }

    @Test
    public void testGroupDeletion() {
       List<GroupData> before=app.group().list();
       int index = before.size() - 1;
       app.group().delete(index);
       List<GroupData> after = app.group().list();
       before.remove(index);
       Assert.assertEquals (before, after);
    }
}
