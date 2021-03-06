package ru.stqa.pft.addressbook.Task5.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.Task5.model.GroupData;

public class GroupHelper extends BaseHelper{

    public GroupHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_footer"), groupData.getFooter());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_name"), groupData.getName());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void deleteSelectedGroup() {
        click(By.name("delete"));
    }
}
