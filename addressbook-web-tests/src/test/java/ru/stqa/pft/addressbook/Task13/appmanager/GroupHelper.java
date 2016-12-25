package ru.stqa.pft.addressbook.Task13.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.Task13.model.GroupData;
import ru.stqa.pft.addressbook.Task13.model.Groups;

import java.util.List;

public class GroupHelper extends BaseHelper {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void deleteSelectedGroup() {
        click(By.name("delete"));
    }

    public void initGroupModification() {
    click(By.name("edit"));
    }

    public void submitUpdateGroupModification() {
        click(By.name("update"));
    }

    public void create(GroupData group) {
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        groupCash = null;
        returnToGroupPage();
    }

    public void modify(GroupData group) {
        selectGroupById(group.getId());
        initGroupModification();
        fillGroupForm(group);
        submitUpdateGroupModification();
        groupCash = null;
        returnToGroupPage();
    }

    public void delete(GroupData group) {
        selectGroupById(group.getId());
        deleteSelectedGroup();
        groupCash = null;
        returnToGroupPage();
    }

    private void selectGroupById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public void check() {
        if (! isThereAGroup()) {
            create(new GroupData().withName("test"));
        }
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    private Groups groupCash = null;

    public Groups all() {
        if (groupCash !=null) {
            return new Groups(groupCash);
        }
        groupCash = new Groups();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element:elements){
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String name = element.getText();
            groupCash.add (new GroupData().withId(id).withName(name));
        }
        return new Groups(groupCash);
    }
}
