package ru.stqa.pft.addressbook.Task5.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class AppManager {
    FirefoxDriver wd;

    private GroupHelper groupHelper;
    private ContactHelper contactHelper;
    private NavigationHelper navigationHelper;

    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void init() {
        this.wd = new FirefoxDriver();
        this.wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        this.wd.get("http://localhost/addressbook/group.php");
        groupHelper = new GroupHelper(this.wd);
        contactHelper = new ContactHelper(this.wd);
        navigationHelper = new NavigationHelper(this.wd);
        login("admin", "secret");
    }

    private void login(String username, String password) {
        this.wd.findElement(By.name("user")).click();
        this.wd.findElement(By.name("user")).clear();
        this.wd.findElement(By.name("user")).sendKeys(username);
        this.wd.findElement(By.name("pass")).click();
        this.wd.findElement(By.name("pass")).clear();
        this.wd.findElement(By.name("pass")).sendKeys(password);
        this.wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
    }

    public void stop() {
        this.wd.quit();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}