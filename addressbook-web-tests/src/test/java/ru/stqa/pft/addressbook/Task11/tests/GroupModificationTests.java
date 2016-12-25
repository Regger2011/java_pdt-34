package ru.stqa.pft.addressbook.Task11.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Task11.model.GroupData;
import java.util.Set;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void insurePreconditionsForGroups () {
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withName("test1"));
        }
    }

    @Test
    public void testGroupModification () {
        Set<GroupData> before=app.group().all();
        GroupData modyfiedGroup = before.iterator().next();
        GroupData group = new GroupData()
                .withId(modyfiedGroup.getId())
                .withName("tEsT1")
                .withHeader("tEsT2")
                .withFooter("tEsT3");
        app.group().modify(group);
        Set<GroupData> after = app.group().all();
        before.remove(modyfiedGroup);
        before.add(group);
        Assert.assertEquals(before,after);
    }
}
