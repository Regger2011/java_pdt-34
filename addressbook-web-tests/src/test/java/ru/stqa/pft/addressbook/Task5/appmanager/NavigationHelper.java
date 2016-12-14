package ru.stqa.pft.addressbook.Task5.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper {
    private FirefoxDriver wd;

    public NavigationHelper(FirefoxDriver wd) {
        this.wd=wd;
    }

    public void gotoHomePage() {
        wd.findElement(By.linkText("home")).click();
    }

    public void gotoAddContactPage() {
        wd.findElement(By.linkText("add new")).click();
    }

    public void gotoGroupsPage() {
        wd.findElement(By.linkText("groups")).click();
    }

    public void gotoNextBirthdaysPage() {
        wd.findElement(By.linkText("next birthdays")).click();
    }

    public void gotoPrintAllPage() {
        wd.findElement(By.linkText("print all")).click();
    }

    public void gotoPrintPhonesPage() {
        wd.findElement(By.linkText("print phones")).click();
    }

    public void gotoMapPage() {
        wd.findElement(By.linkText("map")).click();
    }

    public void gotoExportPage() {
        wd.findElement(By.linkText("export")).click();
    }

    public void gotoImportPage() {
        wd.findElement(By.linkText("import")).click();
    }


    public void backToPreviousPage() {
        wd.navigate().back();
    }

    public void logout() {
        wd.findElement(By.linkText("Logout")).click();
    }
}