package ru.stqa.pft.addressbook.Task6.appmanager;

import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class AppManager {
    FirefoxDriver wd;

    private SessionHelper sessionHelper;
    private GroupHelper groupHelper;
    private ContactHelper contactHelper;
    private NavigationHelper navigationHelper;

    public void init() {
        this.wd = new FirefoxDriver();
        this.wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.wd.get("http://localhost/addressbook/group.php");
        sessionHelper = new SessionHelper(this.wd);
        groupHelper = new GroupHelper(this.wd);
        contactHelper = new ContactHelper(this.wd);
        navigationHelper = new NavigationHelper(this.wd);
        sessionHelper.login("admin", "secret");
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

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }
}