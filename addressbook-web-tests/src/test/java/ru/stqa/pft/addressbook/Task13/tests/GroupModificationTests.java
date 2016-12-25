package ru.stqa.pft.addressbook.Task13.tests;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.Task13.model.GroupData;
import ru.stqa.pft.addressbook.Task13.model.Groups;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

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
        Groups before=app.group().all();
        GroupData modyfiedGroup = before.iterator().next();
        GroupData group = new GroupData()
                .withId(modyfiedGroup.getId())
                .withName("tEsT1")
                .withHeader("tEsT2")
                .withFooter("tEsT3");
        app.group().modify(group);
        assertEquals(app.group().count(),before.size());
        Groups after = app.group().all();
        assertThat(after, CoreMatchers.equalTo(before.without(modyfiedGroup).withAdded(group)));
    }
}
