package ru.stqa.pft.addressbook.Task7.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends BaseHelper {

    public NavigationHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void gotoHomePage() {
        click (By.linkText("home"));
    }

    public void gotoAddContactPage() {
        click(By.linkText("add new"));
    }

    public void gotoGroupsPage() {
        click(By.linkText("groups"));
    }

    public void gotoNextBirthdaysPage() {
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
        click(By.linkText("export"));
    }

    public void gotoImportPage() {
        click(By.linkText("import"));
    }

    public void backToPreviousPage() {
        wd.navigate().back();
    }

    public void selection() {
        click(By.name("selected[]"));
    }

}