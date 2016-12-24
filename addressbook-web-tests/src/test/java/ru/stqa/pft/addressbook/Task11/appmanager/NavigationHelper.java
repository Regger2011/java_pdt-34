package ru.stqa.pft.addressbook.Task11.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends BaseHelper {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void contactPage() {
        if (isElementPresent(By.id("maintable"))) {
            return;
        }
        click (By.linkText("home"));
    }

    public void addContact() {
        if (isElementPresent(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Edit / add address book entry")){
            return;
        }
        click(By.linkText("add new"));
    }

    public void groupPage() {
        if (isElementPresent(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPresent(By.name("new"))) {
            return;
        }
        click(By.linkText("groups"));
    }
    public void editContact() {
        if (isElementPresent(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPresent(By.name("update"))) {
            return;
        }
        groupPage();
        click(By.name("edit"));
    }

    public void newGroup() {
        if (isElementPresent(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPresent(By.name("submit"))) {
            return;
        }
        groupPage();
        click(By.name("new"));
    }

    public void gotoNextBirthdaysPage() {
        if (isElementPresent(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Next birthdays")){
            return;
        }
        click(By.linkText("next birthdays"));
    }

    public void gotoPrintAllPage() {
        click(By.linkText("print all"));
    }

    public void gotoPrintPhonesPage() {
        click(By.linkText("print phones"));
    }

    public void gotoMapPage() {
        click(By.linkText("map"));
    }

    public void gotoExportPage() {
        if (isElementPresent(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Export")){
            return;
        }
        click(By.linkText("export"));
    }

    public void gotoImportPage() {
        if (isElementPresent(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Import")){
            return;
        }
        click(By.linkText("import"));
    }

    public void backToPreviousPage() {
        wd.navigate().back();
    }

    public void selection(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

}