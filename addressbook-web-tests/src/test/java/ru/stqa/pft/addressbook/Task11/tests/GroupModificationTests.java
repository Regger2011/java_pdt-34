package ru.stqa.pft.addressbook.Task11.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Task11.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void insurePreconditionsForGroups () {
        app.goTo().groupPage();
        if (app.group().list().size() == 0) {
            app.group().create(new GroupData("test", null, null));
        }
    }

    @Test
    public void testGroupModification () {
        List<GroupData> before=app.group().list();
        int index = before.size() - 1;
        GroupData group = new GroupData(before.get(index).getId(),"tEsT1", "tEsT2", "tEsT3");
        app.group().modify(index, group);
        List<GroupData> after = app.group().list();
        before.remove(index);
        before.add(group);
        Assert.assertEquals (new HashSet<Object>(before),new HashSet<Object>(after));
    }
}
